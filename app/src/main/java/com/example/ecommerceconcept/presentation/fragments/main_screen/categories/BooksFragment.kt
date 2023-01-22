package com.example.ecommerceconcept.presentation.fragments.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecommerceconcept.databinding.FragmentBooksBinding

class BooksFragment: BaseCategoryFragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding: FragmentBooksBinding
        get() = _binding ?: throw RuntimeException("BooksFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}