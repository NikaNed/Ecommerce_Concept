package com.example.ecommerceconcept.presentation.fragments.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.models.PhoneDetailInfo
import com.example.ecommerceconcept.domain.usecase.GetPhoneDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
            val response = getPhoneDetailUseCase.invoke()
            if (response == null) {
                _progressBar.value = false
            } else {
                _detailInfo.value = response
                _progressBar.value = false

            }
        }
    }
}

