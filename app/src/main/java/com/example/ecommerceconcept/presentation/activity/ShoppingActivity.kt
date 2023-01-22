package com.example.ecommerceconcept.presentation.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityShoppingBinding
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.CartFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.FavoriteFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.HomeFragment
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.ProfileFragment

class ShoppingActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EcommerceConcept)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    setUpCurrentFragment(HomeFragment())
                }

                R.id.cartFragment -> {
                    setUpCurrentFragment(CartFragment())
                }

                R.id.favoriteFragment -> {
                    setUpCurrentFragment(FavoriteFragment())
                }

                R.id.profileFragment -> {
                    setUpCurrentFragment(ProfileFragment())
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