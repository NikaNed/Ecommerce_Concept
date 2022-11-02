package com.example.ecommerceconcept.presentation.main_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentHomeBinding
import com.example.ecommerceconcept.presentation.adapters.CategoryViewpagerAdapter
import com.example.ecommerceconcept.presentation.main_screen.categories.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.custom_tab.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("HomeFragment == null")

//    private val tabTitle = mutableMapOf(
//        "Phone" to R.drawable.ic_phone, "Computer" to R.drawable.ic_computer,
//        "Health" to R.drawable.ic_health, "Books" to R.drawable.ic_books
//    )

    //    private val tabTitle = arrayListOf("Phone","Computer","Health","Books","Accessorise")

    private val categoriesFragments = arrayListOf<Fragment>(
        PhoneFragment(),
        ComputerFragment(),
        HealthFragment(),
        BooksFragment(),
        AccessoriesFragment(),
        BooksFragment(),

        )

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
    }

    private fun setupViewPager() {

        val headerView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null,false)

        val viewPagerAdapter = CategoryViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
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
                4 -> {
                    tab.customView = headerView.findViewById(R.id.tab5)
                }
            }
        }.attach()
    }
}

//        val viewPagerAdapter =
//            CategoryViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
//        binding.viewPagerCategory.adapter = viewPagerAdapter
//        TabLayoutMediator(binding.tabLayout, binding.viewPagerCategory) { tab, position ->
//            when (position) {
//                0 -> {
//                    tab.text = "Phone"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_phone)
//
//                }
//                1 -> {
//                    tab.text = "Computer"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_computer)
//                }
//                2 -> {
//                    tab.text = "Health"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_health)
//                }
//                3 -> {
//                    tab.text = "Books"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_books)
//                }
//                4 -> {
//                    tab.text = "Accessories"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_computer)
//                }
//                5 -> {
//                    tab.text = "Accessories"
//                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_computer)
//                }
//            }
//        }.attach()



//    private fun setUpTabLayoutWithViewPager() {
//        val title = ArrayList(tabTitle.keys)
//        binding.viewPagerCategory.adapter = CategoryViewpagerAdapter(this)
//        TabLayoutMediator(binding.tabLayout, binding.viewPagerCategory) { tab, position ->
//            tab.text = title[position]
//        }.attach()

//        for (i in 0..3){
//            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null)
//                        as TextView
//            binding.tabLayout.getTabAt(i)?.customView = textView
//        }

//        tabTitle.values.forEachIndexed { index, imageResId ->
//            val textView =
//                LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null)
//                        as TextView
//            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, imageResId, 0, 0)
//            textView.compoundDrawablePadding = TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP, 4f, resources.displayMetrics
//            ).roundToInt()
//            binding.tabLayout.getTabAt(index)?.customView = textView
//        }


