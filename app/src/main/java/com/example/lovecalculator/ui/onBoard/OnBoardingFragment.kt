package com.example.lovecalculator.ui.onBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment(){

    private val viewModel: OnBoardingViewModel by viewModels()
    lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardingAdapter {
            start()
        }

        binding.rvBoarding.adapter = adapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvBoarding)

        binding.indicator.attachToRecyclerView(binding.rvBoarding, snapHelper)

        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        binding.tvSkip.setOnClickListener {
            start()
        }
    }

    private fun start() {
        viewModel.saveShown()
        findNavController().navigateUp()
    }
}