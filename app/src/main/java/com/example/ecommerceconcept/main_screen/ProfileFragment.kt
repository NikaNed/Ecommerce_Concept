package com.example.ecommerceconcept.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.databinding.FragmentCartBinding

class ProfileFragment: Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding
    get() = _binding ?: throw RuntimeException("CartFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }
}