package com.example.ecommerceconcept.presentation.screen.main_screen


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityShoppingBinding
import com.example.ecommerceconcept.presentation.screen.main_screen.shopping.CartFragment
import com.example.ecommerceconcept.presentation.screen.main_screen.shopping.FavoriteFragment
import com.example.ecommerceconcept.presentation.screen.main_screen.shopping.HomeFragment
import com.example.ecommerceconcept.presentation.screen.main_screen.shopping.ProfileFragment

class ShoppingActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

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