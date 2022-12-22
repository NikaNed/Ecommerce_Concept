package com.example.ecommerceconcept.domain.usecase

import com.example.ecommerceconcept.domain.PhoneRepository
import javax.inject.Inject


class GetPhoneListUseCase @Inject constructor (
    private val repository: PhoneRepository
) {

    suspend operator fun invoke() = repository.getPhoneInfoList()
}