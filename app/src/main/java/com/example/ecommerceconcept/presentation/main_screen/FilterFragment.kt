package com.example.ecommerceconcept.presentation.main_screen

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.navigation.fragment.findNavController
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFilterBinding? = null
    val binding: FragmentFilterBinding
        get() = _binding ?: throw RuntimeException("FragmentFilter == null")

    private val phoneBrand = arrayOf("Samsung", "IPhone","Xiaomi", "Motorola")
    private val phonePrice = arrayOf("0-$500","$500-$5000","5000-$10000")
    private val phoneSize = arrayOf("4.5 to 5.5 inches","5.5 to 6.5 inches")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_dropdown_item, phoneBrand) as SpinnerAdapter
        binding.spinnerBrand.adapter = adapter

        val adapterPrice = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_dropdown_item, phonePrice) as SpinnerAdapter
        binding.spinnerPrice.adapter = adapterPrice

        val adapterSize = ArrayAdapter(requireContext(),
            android.R.layout.simple_spinner_dropdown_item, phoneSize) as SpinnerAdapter
        binding.spinnerSize.adapter = adapterSize

        binding.apply {
            btDone.setOnClickListener { findNavController().popBackStack() }
            btClose.setOnClickListener { findNavController().popBackStack() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




