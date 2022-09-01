package com.example.lovecalculator.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.lovecalculator.common.App
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {

    override fun inflate(inflater: LayoutInflater): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list: ArrayList<String> = arrayListOf()
        App.appDataBase.loveDao().getAll().observe(viewLifecycleOwner) {
            var s = ""
            it.forEach {
                s += it.firstName + " " + it.secondName + "\n"
            }
            binding.textViewHistory.text = s
        }
    }

}