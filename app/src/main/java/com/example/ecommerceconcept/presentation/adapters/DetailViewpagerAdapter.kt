package com.example.ecommerceconcept.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerceconcept.presentation.detail_screen.DetailsFragment
import com.example.ecommerceconcept.presentation.detail_screen.FeatureFragment
import com.example.ecommerceconcept.presentation.detail_screen.ShopFragment

class DetailViewpagerAdapter(
    private val fragments: List<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
    ): FragmentStateAdapter(fm, lifecycle) {

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return  fragments[position]
        }

}
