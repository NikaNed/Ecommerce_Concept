package com.example.ecommerceconcept.presentation.main_screen.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.network.model.BasketDto
import com.example.data.network.model.CartInfoDto
import com.example.ecommerceconcept.domain.usecase.GetCartUseCase
import kotlinx.coroutines.Job
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
) : ViewModel() {

    private val _cartInfo = MutableLiveData<CartInfoDto>()
    val cartInfo: LiveData<CartInfoDto>
        get() = _cartInfo

    private val _basketInfo = MutableLiveData<List<BasketDto>>()
    val basketInfo: LiveData<List<BasketDto>>
        get() = _basketInfo

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean>
        get() = _progressBar

    init {
        _progressBar.value = true
    }

    private var job: Job? = null

    fun getCartInfo() {
//
//        job = CoroutineScope(Dispatchers.IO).launch {
//            val apiInterface = ApiService.create().getCartInfo()
//            withContext(Dispatchers.Main) {
//                apiInterface.enqueue(object : Callback<CartInfoDto> {
//
//                    override fun onResponse(
//                        call: Call<CartInfoDto>,
//                        response: Response<CartInfoDto>,
//                    ) {
//                        _cartInfo.value = (response.body())
//                        _basketInfo.value = (response.body()?.basket)
//                        _progressBar.value = false
//                    }
//
//                    override fun onFailure(call: Call<CartInfoDto>, t: Throwable) {
//                        Log.d("TAG", "onFailure ${t.message}")
//                    }
//                })
//            }
//        }
    }
}
