package com.example.ecommerceconcept.presentation.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconcept.domain.models.PhoneDetailInfo
import com.example.ecommerceconcept.domain.usecase.GetPhoneDetailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneDetailViewModel @Inject constructor(
    private val getPhoneDetailUseCase: GetPhoneDetailUseCase
): ViewModel() {

    private val _detailInfo = MutableLiveData<PhoneDetailInfo>()
    val detailInfo: LiveData<PhoneDetailInfo>
        get() = _detailInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    init {
        _progressBar.value = true
    }

    private var job: Job? = null

    fun getPhoneDetailInfo() {

        job = CoroutineScope(Dispatchers.IO).launch {

            val response = getPhoneDetailUseCase.invoke()
            _detailInfo.postValue(response)
            _progressBar.postValue(false)
        }
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val apiInterface = ApiService.create().getPhoneDetailInfo()
//            withContext(Dispatchers.Main) {
//                apiInterface.enqueue(object : Callback<PhoneDetailInfoDto> {
//
//                    override fun onResponse(
//                        call: Call<PhoneDetailInfoDto>,
//                        response: Response<PhoneDetailInfoDto>
//                    ) {
//                        _detailInfo.value = (response.body())
//                        _progressBar.value = false
//                    }
//
//                    override fun onFailure(call: Call<PhoneDetailInfoDto>, t: Throwable) {
//                        Log.d("TAG", "onFailure ${t.message}")
//                    }
//                })
//            }
//        }
    }
}
