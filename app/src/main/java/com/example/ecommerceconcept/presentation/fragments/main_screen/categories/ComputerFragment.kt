package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceconcept.databinding.FragmentComputerBinding


class ComputerFragment: BaseCategoryFragment() {

    private var _binding: FragmentComputerBinding? = null
    private val binding: FragmentComputerBinding
        get() = _binding ?: throw RuntimeException("ComputerFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentComputerBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}