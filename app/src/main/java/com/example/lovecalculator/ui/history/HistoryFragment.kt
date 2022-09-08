package com.example.lovecalculator.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.common.Repository
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {

    @Inject
    lateinit var repository: Repository

    override fun inflate(inflater: LayoutInflater): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list: ArrayList<String> = arrayListOf()
        repository.getList().observe(viewLifecycleOwner) {
            var s = ""
            it.forEach {
                s += it.firstName + " " + it.secondName + "\n"
            }
            binding.textViewHistory.text = s
        }
    }

}