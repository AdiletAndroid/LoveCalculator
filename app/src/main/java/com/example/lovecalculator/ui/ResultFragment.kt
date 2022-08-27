package com.example.lovecalculator.ui

import android.os.Bundle
import android.view.View
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResult()
    }

    private fun setResult() {
        val result = requireArguments().getString("key")
        binding.textViewResult.text = result
    }

    override fun inflate(): FragmentResultBinding {
        return FragmentResultBinding.inflate(layoutInflater)
    }
}