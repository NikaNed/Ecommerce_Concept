package com.example.ecommerceconcept.presentation.main_screen

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityShoppingBinding
import com.example.ecommerceconcept.presentation.main_screen.shopping.CartFragment
import com.example.ecommerceconcept.presentation.main_screen.shopping.FavoriteFragment
import com.example.ecommerceconcept.presentation.main_screen.shopping.HomeFragment
import com.example.ecommerceconcept.presentation.main_screen.shopping.ProfileFragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.badge_text.view.*

class ShoppingActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    private lateinit var notificationBadges: View
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EcommerceConcept)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

         val cartFragment = CartFragment()
         val homeFragment = HomeFragment()
         val favoriteFragment = FavoriteFragment()
         val profileFragment = ProfileFragment()

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    setUpCurrentFragment(homeFragment)
                }

                R.id.cartFragment -> {
                    setUpCurrentFragment(cartFragment)

                }

                R.id.favoriteFragment -> {
                    setUpCurrentFragment(favoriteFragment)
                }

                R.id.profileFragment -> {
                    setUpCurrentFragment(profileFragment)
                }
            }
            true
        }
    }

    private fun setUpCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.shoppingHostFragment, fragment)
            .addToBackStack(null)
            .commit()
    }

}