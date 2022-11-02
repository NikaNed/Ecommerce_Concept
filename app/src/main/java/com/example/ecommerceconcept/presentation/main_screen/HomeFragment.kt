package com.example.ecommerceconcept.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentHomeBinding
import com.example.ecommerceconcept.presentation.adapters.CategoryViewpagerAdapter
import com.example.ecommerceconcept.presentation.main_screen.categories.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
    get() = _binding ?: throw RuntimeException("HomeFragment == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoriesFragments = arrayListOf<Fragment>(
            PhoneFragment(),
            ComputerFragment(),
            HealthFragment(),
            BooksFragment(),
            AccessoriesFragment()
        )


        val viewPagerAdapter = CategoryViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewPagerCategory.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPagerCategory){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Phone"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_phone)
                }
                1 -> {
                    tab.text = "Computer"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_computer)
                }
                2 -> {
                    tab.text = "Health"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_health)
                }
                3 -> {
                    tab.text = "Books"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_books)
                }
                4 -> {
                    tab.text = "Accessories"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_computer)
                }
            }
        }.attach()
    }
}