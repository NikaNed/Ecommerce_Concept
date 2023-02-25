package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import android.util.Log
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

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("Tag", "Exception caught $throwable")
    }

    fun getHomeStoreInfo() {

        viewModelScope.launch(exceptionHandler) {

            _progressBar.value = true

            val response = getPhoneListUseCase.invoke()
            if (response == null) {
                _progressBar.value = false
            } else {
                _homeStoreInfo.value = response.home_store
                _progressBar.value = false
            }
        }
    }

    fun getBestSellerInfo() {

        viewModelScope.launch(exceptionHandler) {
            _progressBar.value = true

            val response = getPhoneListUseCase.invoke()
            if (response == null) {
                _progressBar.value = false
            } else {
                _bestSellerInfo.value = response.best_seller
                _progressBar.value = false
            }
        }
    }
}
