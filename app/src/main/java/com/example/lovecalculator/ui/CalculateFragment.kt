package com.example.lovecalculator.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import com.example.lovecalculator.network.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        with(binding) {
            buttonCalculate.setOnClickListener {
                calculate()
            }
        }
    }

    private fun FragmentCalculateBinding.calculate() {
        App.api.calculateLove(
            firstName = editTextYou.text.toString(),
            secondName = editTextMe.text.toString()
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                val result = response.body()?.result ?: "Not found"
                val bundle = bundleOf("key" to result)
                findNavController().navigate(R.id.resultFragment, bundle)
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }

        })
    }
}