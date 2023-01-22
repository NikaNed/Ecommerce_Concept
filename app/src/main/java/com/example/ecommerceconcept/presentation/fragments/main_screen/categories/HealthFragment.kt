package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceconcept.databinding.FragmentHealthBinding

class HealthFragment: BaseCategoryFragment() {

    private var _binding: FragmentHealthBinding? = null
    private val binding: FragmentHealthBinding
        get() = _binding ?: throw RuntimeException("HealthFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHealthBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}