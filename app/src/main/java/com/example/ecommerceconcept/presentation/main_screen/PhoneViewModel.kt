package com.example.ecommerceconcept.presentation.main_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconcept.data.HomeStore
import com.example.ecommerceconcept.data.PhoneInfoDto
import com.example.ecommerceconcept.data.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhoneViewModel : ViewModel() {

    private val _homeStoreInfo = MutableLiveData<List<HomeStore>>()
    val homeStoreInfo: LiveData<List<HomeStore>>
        get() = _homeStoreInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar
    init {
        _progressBar.value = true
    }

    fun getHomeStoreInfo() {
        val apiInterface = ApiService.create().getPhoneInfo()

        apiInterface.enqueue(object : Callback<PhoneInfoDto> {

            override fun onResponse(call: Call<PhoneInfoDto>, response: Response<PhoneInfoDto>) {
                _homeStoreInfo.value = (response.body()?.home_store)
                _progressBar.value = false
                Log.d("TAG", "onResponse success $call ${response.body()?.home_store}")
            }

            override fun onFailure(call: Call<PhoneInfoDto>, t: Throwable) {
                Log.d("TAG", "onFailure ${t.message}")
            }
        })
    }
}
