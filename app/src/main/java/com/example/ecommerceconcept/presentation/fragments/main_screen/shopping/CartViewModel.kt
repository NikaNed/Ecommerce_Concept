package com.example.ecommerceconcept.presentation.fragments.main_screen.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.Basket
import com.example.ecommerceconcept.domain.models.CartInfo
import com.example.ecommerceconcept.domain.usecase.GetCartUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
) : ViewModel() {

    private val _cartInfo = MutableLiveData<CartInfo>()
    val cartInfo: LiveData<CartInfo>
        get() = _cartInfo

    private val _basketInfo = MutableLiveData<List<Basket>>()
    val basketInfo: LiveData<List<Basket>>
        get() = _basketInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
    get() = _error

    fun getCartInfo() {

        viewModelScope.launch {
            _progressBar.value = true

            withContext(Dispatchers.IO) {
                val response = getCartUseCase.invoke()
                if (response == null) {
                    withContext(Dispatchers.Main) {
                        _error.postValue("Data not found")
                        _progressBar.postValue(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        _cartInfo.postValue(response)
                        _basketInfo.postValue(response.basket)
                        _progressBar.postValue(false)
                    }
                }
            }
        }
    }
}

