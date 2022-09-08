package com.example.lovecalculator.ui.calculateFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.common.App
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import com.example.lovecalculator.room.AppDataBase
import com.example.lovecalculator.room.LoveEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : BaseFragment<FragmentCalculateBinding>() {

    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var appDataBase: AppDataBase

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

                    val loveEntity = LoveEntity(
                        firstName = it.firstName,
                        secondName = it.secondName,
                        percentage = it.percentage,
                        result = it.result,
                    )
                    appDataBase.loveDao().insert(loveEntity)
                })
            }
            buttonHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    override fun inflate(inflater: LayoutInflater): FragmentCalculateBinding {
        return FragmentCalculateBinding.inflate(inflater)
    }

}