package com.example.ecommerceconcept.presentation.main_screen.shopping

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconcept.data.network.ApiService
import com.example.ecommerceconcept.data.network.model.Basket
import com.example.ecommerceconcept.data.network.model.CartInfo
import com.example.ecommerceconcept.data.network.model.PhoneDetailInfo
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartViewModel : ViewModel() {

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
            val apiInterface = ApiService.create().getCartInfo()
            withContext(Dispatchers.Main) {
                apiInterface.enqueue(object : Callback<CartInfo> {

                    override fun onResponse(call: Call<CartInfo>, response: Response<CartInfo>) {
                        _cartInfo.value = (response.body())
                        _basketInfo.value = (response.body()?.basket)
                        _progressBar.value = false
                    }

                    override fun onFailure(call: Call<CartInfo>, t: Throwable) {
                        Log.d("TAG", "onFailure ${t.message}")
                    }
                })
            }
        }
    }
}
