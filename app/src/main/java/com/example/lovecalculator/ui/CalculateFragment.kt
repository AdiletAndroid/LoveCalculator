package com.example.lovecalculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.LoveViewModel
import com.example.lovecalculator.R
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculateFragment : BaseFragment<FragmentCalculateBinding>() {


    private val viewModel: LoveViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        with(binding) {
            buttonCalculate.setOnClickListener {
                viewModel.fillLoveModel(
                    editTextMe.text.toString(),
                    editTextYou.text.toString()
                ).observe(viewLifecycleOwner, Observer {
                    val result = it.result
                    val bundle = bundleOf("key" to result)
                    findNavController().navigate(R.id.resultFragment, bundle)
                })
            }
        }
    }

    override fun inflate(inflater: LayoutInflater): FragmentCalculateBinding {
        return FragmentCalculateBinding.inflate(inflater)
    }

}