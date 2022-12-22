package com.example.ecommerceconcept.presentation.fragments.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.PhoneDetailInfo
import com.example.ecommerceconcept.domain.usecase.GetPhoneDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhoneDetailViewModel @Inject constructor(
    private val getPhoneDetailUseCase: GetPhoneDetailUseCase,
) : ViewModel() {

    private val _detailInfo = MutableLiveData<PhoneDetailInfo>()
    val detailInfo: LiveData<PhoneDetailInfo>
        get() = _detailInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    fun getPhoneDetailInfo() {


        viewModelScope.launch {

            _progressBar.value = true

            withContext(Dispatchers.IO) {
                val response = getPhoneDetailUseCase.invoke()
                if (response == null) {
                    withContext(Dispatchers.Main) {
//                        _error.postValue("Data not found")
                        _progressBar.postValue(false)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        _detailInfo.postValue(response)
                        _progressBar.postValue(false)
                    }
                }
            }
        }
    }
}

