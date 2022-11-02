package com.example.ecommerceconcept.presentation.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceconcept.databinding.FragmentPhoneBinding

class PhoneFragment: BaseCategoryFragment() {

    private var _binding: FragmentPhoneBinding? = null
    private val binding: FragmentPhoneBinding
        get() = _binding ?: throw RuntimeException("FragmentPhone == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }
}