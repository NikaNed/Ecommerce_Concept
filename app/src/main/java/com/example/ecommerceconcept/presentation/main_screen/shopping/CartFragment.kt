package com.example.ecommerceconcept.presentation.main_screen.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconcept.databinding.FragmentCartBinding
import com.example.ecommerceconcept.presentation.adapters.CartAdapter

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding
        get() = _binding ?: throw RuntimeException("CartFragment == null")

    lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CartViewModel::class.java]
        viewModel.getCartInfo()

        viewModel.cartInfo.observe(viewLifecycleOwner) {
            with(binding) {
                tvTotalPrice.text = it.total.toString() + "us"
                tvDeliveryPrice.text = it.delivery
            }
        }

        viewModel.basketInfo.observe(viewLifecycleOwner) {
            val cartAdapter = CartAdapter()
            with(binding) {
                rvCart.layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false)
                rvCart.adapter = cartAdapter
                cartAdapter.submitList(it)
            }
        }

        binding.btClose.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.btCheckout.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        viewModel.progressBar.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment {
            return CartFragment()
        }
    }
}