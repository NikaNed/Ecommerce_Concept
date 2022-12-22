package com.example.ecommerceconcept.presentation.fragments.detail_screen

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentPhoneDetailBinding
import com.example.ecommerceconcept.presentation.EcommerceApp
import com.example.ecommerceconcept.presentation.fragments.detail_screen.adapters.DetailViewpagerAdapter
import com.example.ecommerceconcept.presentation.fragments.detail_screen.adapters.PhoneDetailAdapter
import com.example.ecommerceconcept.presentation.ViewModelFactory
import com.example.ecommerceconcept.presentation.fragments.main_screen.shopping.CartFragment
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class PhoneDetailFragment : Fragment() {

    private var _binding: FragmentPhoneDetailBinding? = null
    private val binding: FragmentPhoneDetailBinding
        get() = _binding ?: throw RuntimeException("PhoneDetailFragment == null")

    lateinit var viewModel: PhoneDetailViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as EcommerceApp).component
    }

    private val detailsFragments = arrayListOf(
        ShopFragment(),
        DetailsFragment(),
        FeatureFragment()
    )
    private var counter = 0

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentPhoneDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(),
            viewModelFactory)[PhoneDetailViewModel::class.java]

        viewModel.getPhoneDetailInfo()

        observeViewModel()
        setUpViewPager()
        setOnClickCart()
        setOnClickBackPress()
        setUpRatingBar()
        setOnClickAddCart()
        setUpCheckColorListener()
    }

    private fun observeViewModel() {
        viewModel.detailInfo.observe(viewLifecycleOwner) {
            val detailAdapter = PhoneDetailAdapter()
            with(binding) {
                rvDetail.set3DItem(true)
                rvDetail.setInfinite(true)
                rvDetail.setAlpha(true)
                rvDetail.setFlat(true)
                rvDetail.setIsScrollingEnabled(true)
            }

            binding.rvDetail.adapter = detailAdapter
            detailAdapter.submitList(it.images)

            with(binding) {
                tvTitleDetail.text = it.title
                tvProcessor.text = it.CPU
                tvCamera.text = it.camera
                tvMemory.text = it.ssd
                tvStorage.text = it.sd
                ratingBar.rating = it.rating.toFloat()
                colorCircle1.backgroundTintList =
                    ColorStateList.valueOf(Color.parseColor(it.color?.get(0)))
                colorCircle2.backgroundTintList =
                    ColorStateList.valueOf(Color.parseColor(it.color?.get(1)))
                firstCapacity.text = "${it.capacity?.get(0)} GB"
                secondCapacity.text = "${it.capacity?.get(1)} GB"
                btAddCart.text = "Add to Card           " + "$" + "%,d".format(it.price)

                if (it.isFavorites) {
                    cvFavorite.setImageResource(R.drawable.ic_heart_full)
                } else {
                    cvFavorite.setImageResource(R.drawable.ic_heart)
                }
            }

            binding.firstCapacity.setOnClickListener { selectCapacity(true) }
            binding.secondCapacity.setOnClickListener { selectCapacity(false) }
        }

        binding.icChecked2.visibility = View.GONE
        binding.icChecked1.visibility = View.GONE

        viewModel.progressBar.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }

    private fun setUpRatingBar() {
        val rBar = RatingBar(requireContext())
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        rBar.layoutParams = layoutParams
        rBar.stepSize = 1.0.toFloat()
        rBar.numStars = 5
    }

    private fun setUpCheckColorListener() {
        with(binding) {
            colorCircle1.setOnClickListener {
                icChecked2.visibility = View.GONE
                icChecked1.visibility = View.VISIBLE
            }
            colorCircle2.setOnClickListener {
                icChecked1.visibility = View.GONE
                icChecked2.visibility = View.VISIBLE
            }
        }

    }

    private fun selectCapacity(gb: Boolean) {
        binding.firstCapacity.run {
            background =
                resources.getDrawable(if (gb) R.drawable.color_bg_orange else R.drawable.color_bg)
            binding.firstCapacity.setTextColor(if (gb) resources.getColor(R.color.white) else resources.getColor(
                R.color.grey_text))
        }
        binding.secondCapacity.run {
            background =
                resources.getDrawable(if (gb) R.drawable.color_bg else R.drawable.color_bg_orange)
            binding.secondCapacity.setTextColor(if (gb) resources.getColor(R.color.grey_text) else resources.getColor(
                R.color.white))
        }
    }

    private fun setOnClickBackPress() {
        binding.btClose.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setOnClickCart() {
        binding.btCart.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.shoppingHostFragment, CartFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun setOnClickAddCart() {
        binding.btAddCart.setOnClickListener {
            counter += 1
            binding.badgeCart.visibility = View.VISIBLE
            binding.badgeCart.text = counter.toString()
        }
    }

    private fun setUpViewPager() {
        val viewPagerAdapter =
            DetailViewpagerAdapter(detailsFragments, childFragmentManager, lifecycle)
        binding.viewPagerDetail.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayoutDetail, binding.viewPagerDetail) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Shop"
                }
                1 -> {
                    tab.text = "Details"
                }
                2 -> {
                    tab.text = "Features"
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): Fragment {
            return PhoneDetailFragment()
        }
    }
}
