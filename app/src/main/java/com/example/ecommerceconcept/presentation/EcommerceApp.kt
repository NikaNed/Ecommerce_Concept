package com.example.ecommerceconcept.presentation

import android.app.Application
import com.example.ecommerceconcept.presentation.di.DaggerApplicationComponent


class EcommerceApp: Application() {


    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}