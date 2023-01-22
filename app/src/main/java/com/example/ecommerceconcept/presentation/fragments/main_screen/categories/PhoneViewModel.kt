package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.BestSeller
import com.example.ecommerceconcept.domain.models.HomeStore
import com.example.ecommerceconcept.domain.usecase.GetPhoneListUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class PhoneViewModel @Inject constructor(
    private val getPhoneListUseCase: GetPhoneListUseCase,
) : ViewModel() {

    private val _homeStoreInfo = MutableLiveData<List<HomeStore>>()
    val homeStoreInfo: LiveData<List<HomeStore>>
        get() = _homeStoreInfo

    private val _bestSellerInfo = MutableLiveData<List<BestSeller>>()
    val bestSellerInfo: LiveData<List<BestSeller>>
        get() = _bestSellerInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    fun getHomeStoreInfo() {

        viewModelScope.launch {
            _progressBar.value = true

            withContext(Dispatchers.IO) {
                val response = getPhoneListUseCase.invoke()
                if (response == null) {
                    withContext(Dispatchers.Main) {
//                        _error.postValue("Data not found")
                        _progressBar.postValue(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        _homeStoreInfo.postValue(response.home_store)
                        _progressBar.postValue(false)
                    }
                }
            }
        }
    }

    fun getBestSellerInfo() {

        viewModelScope.launch {
            _progressBar.value = true

            withContext(Dispatchers.IO) {
                val response = getPhoneListUseCase.invoke()
                if (response == null) {
                    withContext(Dispatchers.Main) {
//                        _error.postValue("Data not found")
                        _progressBar.postValue(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        _bestSellerInfo.postValue(response.best_seller)
                        _progressBar.postValue(false)
                    }
                }
            }
        }
    }
}
