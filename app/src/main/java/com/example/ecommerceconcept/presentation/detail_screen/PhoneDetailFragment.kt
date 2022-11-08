package com.example.ecommerceconcept.presentation.detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceconcept.databinding.FragmentPhoneDetailBinding
import com.example.ecommerceconcept.presentation.adapters.DetailViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PhoneDetailFragment : Fragment() {

    private var _binding: FragmentPhoneDetailBinding? = null
    private val binding: FragmentPhoneDetailBinding
        get() = _binding ?: throw RuntimeException("PhoneDetailFragment == null")

    //    private val args: PhoneDetailFragmentArgs by navArgs()
    lateinit var viewModel: PhoneDetailViewModel

    private val detailsFragments = arrayListOf(
        ShopFragment(),
        DetailsFragment(),
        FeatureFragment()
    )

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
//        val product = args.product

        viewModel = ViewModelProvider(this)[PhoneDetailViewModel::class.java]
        viewModel.getPhoneDetailInfo()

        setUpViewPager()

        // Create RatingBar
        val rBar = RatingBar(requireContext())
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        rBar.layoutParams = layoutParams
        rBar.stepSize = 1.0.toFloat()
        rBar.numStars = 5


        viewModel.detailInfo.observe(viewLifecycleOwner) {
//            val hotSalesAdapter = HotSalesAdapter()
//            with(binding) {
//                rvHotSales.layoutManager = LinearLayoutManager(
//                    requireContext(),
//                    LinearLayoutManager.HORIZONTAL,
//                    false)
//                rvHotSales.adapter = hotSalesAdapter
//                hotSalesAdapter.submitList(it)

                binding.tvTitleDetail.text = it.title
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


