package com.example.ecommerceconcept.presentation.di

import android.app.Application
import com.example.ecommerceconcept.presentation.fragments.detail_screen.PhoneDetailFragment
import com.example.ecommerceconcept.presentation.EcommerceApp
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.PhoneFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.CartFragment
import dagger.BindsInstance
import dagger.Component

@Component (modules = [DataModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun inject(fragment: PhoneFragment)
    fun inject(fragment: CartFragment)
    fun inject(fragment: PhoneDetailFragment)
    fun inject(application: EcommerceApp)

    @Component.Factory
    interface Factory {
        fun create (
            @BindsInstance application: Application
        ) : ApplicationComponent
    }
}