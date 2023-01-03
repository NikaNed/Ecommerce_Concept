package com.example.ecommerceconcept.presentation.di

import com.example.ecommerceconcept.data.repositories.PhoneRepositoryImpl
import com.example.ecommerceconcept.data.network.api.ApiFactory
import com.example.ecommerceconcept.data.network.api.ApiService
import com.example.ecommerceconcept.domain.PhoneRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindPhoneRepository(impl: PhoneRepositoryImpl): PhoneRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}