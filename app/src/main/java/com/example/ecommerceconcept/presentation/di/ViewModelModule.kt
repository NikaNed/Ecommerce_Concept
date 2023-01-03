package com.example.ecommerceconcept.presentation.di

import androidx.lifecycle.ViewModel
import com.example.ecommerceconcept.presentation.fragments.detail_screen.PhoneDetailViewModel
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.PhoneViewModel
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(PhoneViewModel::class)
    @Binds
    fun bindPhoneViewModel(viewModel: PhoneViewModel) : ViewModel

    @IntoMap
    @ViewModelKey(CartViewModel::class)
    @Binds
    fun bindCartViewModel(viewModel: CartViewModel) : ViewModel

    @IntoMap
    @ViewModelKey(PhoneDetailViewModel::class)
    @Binds
    fun bindPhoneDetailViewModel(viewModel: PhoneDetailViewModel) : ViewModel
}