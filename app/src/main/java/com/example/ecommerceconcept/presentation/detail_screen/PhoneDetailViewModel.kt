package com.example.ecommerceconcept.presentation.detail_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconcept.data.network.model.BestSeller
import com.example.ecommerceconcept.data.network.model.HomeStore
import com.example.ecommerceconcept.data.network.model.PhoneInfoDto
import com.example.ecommerceconcept.data.network.ApiService
import com.example.ecommerceconcept.data.network.PhoneDetailInfo
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

    fun getPhoneDetailInfo() {
        val apiInterface = ApiService.create().getPhoneDetailInfo()

        apiInterface.enqueue(object : Callback<PhoneDetailInfo> {

            override fun onResponse(call: Call<PhoneDetailInfo>, response: Response<PhoneDetailInfo>) {
                _detailInfo.value = (response.body())
                _progressBar.value = false
                Log.d("TAG", "onResponse success $call ${response.body()}")
            }

            override fun onFailure(call: Call<PhoneDetailInfo>, t: Throwable) {
                Log.d("TAG", "onFailure ${t.message}")
            }
        })
    }
}
