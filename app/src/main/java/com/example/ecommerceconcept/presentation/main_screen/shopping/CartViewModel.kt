package com.example.ecommerceconcept.presentation.main_screen.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.network.model.BasketDto
import com.example.data.network.model.CartInfoDto
import com.example.ecommerceconcept.domain.models.Basket
import com.example.ecommerceconcept.domain.models.CartInfo
import com.example.ecommerceconcept.domain.usecase.GetCartUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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

    init {
        _progressBar.value = true
    }

    private var job: Job? = null

    fun getCartInfo() {

        job = CoroutineScope(Dispatchers.IO).launch {

            val response = getCartUseCase.invoke()
            _cartInfo.postValue(response)
            _basketInfo.postValue(response.basket)
            _progressBar.postValue(false)
        }
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val apiInterface = ApiService.create().getCartInfo()
//            withContext(Dispatchers.Main) {
//                apiInterface.enqueue(object : Callback<CartInfoDto> {
//
//                    override fun onResponse(
//                        call: Call<CartInfoDto>,
//                        response: Response<CartInfoDto>,
//                    ) {
//                        _cartInfo.value = (response.body())
//                        _basketInfo.value = (response.body()?.basket)
//                        _progressBar.value = false
//                    }
//
//                    override fun onFailure(call: Call<CartInfoDto>, t: Throwable) {
//                        Log.d("TAG", "onFailure ${t.message}")
//                    }
//                })
//            }
//        }
    }
}
