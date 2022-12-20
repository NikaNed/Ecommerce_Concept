package com.example.ecommerceconcept.presentation.main_screen.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.network.model.BestSellerDto
import com.example.data.network.model.HomeStoreDto
import com.example.ecommerceconcept.domain.usecase.GetPhoneListUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

class PhoneViewModel @Inject constructor(
    private val getPhoneListUseCase: GetPhoneListUseCase,
) : ViewModel() {

    private val _homeStoreInfo = MutableLiveData<List<HomeStoreDto>>()
    val homeStoreInfo: LiveData<List<HomeStoreDto>>
        get() = _homeStoreInfo

    private val _bestSellerInfo = MutableLiveData<List<BestSellerDto>>()
    val bestSellerInfo: LiveData<List<BestSellerDto>>
        get() = _bestSellerInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    init {
        _progressBar.value = true
    }

    private var job: Job? = null

    fun getHomeStoreInfo() {

        job = CoroutineScope(Dispatchers.IO).launch {
//            val apiInterface = ApiService.create().getPhoneInfo()

//            val response = getPhoneListUseCase.invoke()
            withContext(Dispatchers.Main) {
//                _homeStoreInfo.value = (response.body()?.home_store)
                _progressBar.value = false
            }

//                apiInterface.enqueue(object : Callback<PhoneInfoDto> {
//
//                    override fun onResponse(
//                        call: Call<PhoneInfoDto>,
//                        response: Response<PhoneInfoDto>
//                    ) {
//                        _homeStoreInfo.value = (response.body()?.home_store)
//                        _progressBar.value = false
//                        Log.d("TAG", "onResponse success $call ${response.body()?.home_store}")
//                    }
//
//                    override fun onFailure(call: Call<PhoneInfoDto>, t: Throwable) {
//                        Log.d("TAG", "onFailure ${t.message}")
//                    }
//                })

        }
    }

    fun getBestSellerInfo() {
//
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val apiInterface = ApiService.create().getPhoneInfo()
//
//            apiInterface.enqueue(object : Callback<PhoneInfoDto> {
//
//                override fun onResponse(
//                    call: Call<PhoneInfoDto>,
//                    response: Response<PhoneInfoDto>
//                ) {
//                    _bestSellerInfo.value = (response.body()?.best_seller)
//                    _progressBar.value = false
//                    Log.d("TAG", "onResponse success $call ${response.body()?.best_seller}")
//                }
//
//                override fun onFailure(call: Call<PhoneInfoDto>, t: Throwable) {
//                    Log.d("TAG", "onFailure ${t.message}")
//                }
//            })
//        }
    }
}
