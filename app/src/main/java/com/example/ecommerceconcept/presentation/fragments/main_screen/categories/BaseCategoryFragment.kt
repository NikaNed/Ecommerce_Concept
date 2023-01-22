package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.databinding.FragmentBaseCategoryBinding

open class BaseCategoryFragment: Fragment() {

    private var _binding: FragmentBaseCategoryBinding? = null
    private val binding: FragmentBaseCategoryBinding
        get() = _binding ?: throw RuntimeException("BaseCategoryFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBaseCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}