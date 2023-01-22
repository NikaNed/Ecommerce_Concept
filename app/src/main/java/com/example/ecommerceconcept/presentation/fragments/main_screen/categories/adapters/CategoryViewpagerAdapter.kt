package com.example.ecommerceconcept.presentation.fragments.main_screen.categories.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.BooksFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.ComputerFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.HealthFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.categories.PhoneFragment

class CategoryViewpagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PhoneFragment()
            1 -> ComputerFragment()
            2 -> HealthFragment()
            3 -> BooksFragment()
            else -> {
                PhoneFragment()
            }
        }
    }
}