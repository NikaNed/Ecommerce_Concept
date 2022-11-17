package com.example.ecommerceconcept.presentation.main_screen.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.data.network.model.BestSeller
import com.example.ecommerceconcept.databinding.FragmentPhoneBinding
import com.example.ecommerceconcept.presentation.adapters.BestSellerAdapter
import com.example.ecommerceconcept.presentation.adapters.HotSalesAdapter
import com.example.ecommerceconcept.presentation.detail_screen.PhoneDetailFragment

class PhoneFragment : BaseCategoryFragment(), BestSellerAdapter.BestSellerListener {

    private var _binding: FragmentPhoneBinding? = null
    private val binding: FragmentPhoneBinding
        get() = _binding ?: throw RuntimeException("FragmentPhone == null")

    private lateinit var viewModel: PhoneViewModel

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

        viewModel = ViewModelProvider(this)[PhoneViewModel::class.java]
        viewModel.getHomeStoreInfo()
        viewModel.getBestSellerInfo()

        viewModel.homeStoreInfo.observe(viewLifecycleOwner) {
            val hotSalesAdapter = HotSalesAdapter()
            with(binding) {
                rvHotSales.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false)
                rvHotSales.adapter = hotSalesAdapter
                hotSalesAdapter.submitList(it)
            }
        }

        viewModel.bestSellerInfo.observe(viewLifecycleOwner) {
            val bestSellerAdapter = BestSellerAdapter(this)
            with(binding) {
                rvBestSeller.layoutManager = GridLayoutManager(requireContext(), 2)
                rvBestSeller.adapter = bestSellerAdapter
                bestSellerAdapter.submitList(it)
            }
        }
        viewModel.progressBar.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }

    override fun onClick(product:BestSeller) {

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.shoppingHostFragment, PhoneDetailFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}