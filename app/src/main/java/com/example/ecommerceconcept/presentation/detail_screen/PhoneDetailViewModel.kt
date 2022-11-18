package com.example.ecommerceconcept.presentation.detail_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.data.network.ApiService
import com.example.data.data.network.model.PhoneDetailInfo
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhoneDetailViewModel : ViewModel() {

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
            val apiInterface = ApiService.create().getPhoneDetailInfo()
            withContext(Dispatchers.Main) {
                apiInterface.enqueue(object : Callback<PhoneDetailInfo> {

                    override fun onResponse(
                        call: Call<PhoneDetailInfo>,
                        response: Response<PhoneDetailInfo>
                    ) {
                        _detailInfo.value = (response.body())
                        _progressBar.value = false
                    }

                    override fun onFailure(call: Call<PhoneDetailInfo>, t: Throwable) {
                        Log.d("TAG", "onFailure ${t.message}")
                    }
                })
            }
        }
    }
}
