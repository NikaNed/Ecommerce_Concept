package com.example.ecommerceconcept.presentation.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.databinding.FragmentPhoneBinding
import com.example.ecommerceconcept.presentation.adapters.HotSalesAdapter
import com.example.ecommerceconcept.presentation.main_screen.PhoneViewModel

class PhoneFragment : BaseCategoryFragment() {

    private var _binding: FragmentPhoneBinding? = null
    private val binding: FragmentPhoneBinding
        get() = _binding ?: throw RuntimeException("FragmentPhone == null")

    private lateinit var hotSalesAdapter: HotSalesAdapter
    private lateinit var viewModel: PhoneViewModel
//    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[PhoneViewModel::class.java]

        viewModel = ViewModelProvider(this)[PhoneViewModel::class.java]
        viewModel.getHomeStoreInfo()

        viewModel.homeStoreInfo.observe(viewLifecycleOwner) {
            hotSalesAdapter = HotSalesAdapter()
            with(binding) {
                rvHotSales.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false)
                rvHotSales.adapter = hotSalesAdapter
                hotSalesAdapter.submitList(it)
            }
        }

        viewModel.progressBar.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
    }

//    private fun setUpHotSalesRV() {
//        hotSalesAdapter = HotSalesAdapter()
//        binding.rvHotSales.apply {
//            layoutManager = LinearLayoutManager(
//                requireContext(),
//                LinearLayoutManager.HORIZONTAL,
//                false
//            )
//            adapter = hotSalesAdapter
//        }
//    }
}