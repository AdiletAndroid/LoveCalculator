package com.example.lovecalculator.ui.calculateFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.common.Repository
import com.example.lovecalculator.network.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun fillLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        return repository.getLoveModel(firstName, secondName)
    }

}