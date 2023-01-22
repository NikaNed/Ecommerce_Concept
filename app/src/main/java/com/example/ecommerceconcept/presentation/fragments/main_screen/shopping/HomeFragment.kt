package com.example.ecommerceconcept.presentation.fragments.main_screen.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentHomeBinding
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters.CategoryViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("HomeFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()

        binding.btFilter.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToFilterFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupViewPager() {

        val headerView =
            LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null, false)

        val viewPagerAdapter =
            CategoryViewpagerAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        binding.viewPagerCategory.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPagerCategory) { tab, position ->
            when (position) {
                0 -> {
                    tab.customView = headerView.findViewById(R.id.tab1)
                }
                1 -> {
                    tab.customView = headerView.findViewById(R.id.tab2)
                }
                2 -> {
                    tab.customView = headerView.findViewById(R.id.tab3)
                }
                3 -> {
                    tab.customView = headerView.findViewById(R.id.tab4)
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




