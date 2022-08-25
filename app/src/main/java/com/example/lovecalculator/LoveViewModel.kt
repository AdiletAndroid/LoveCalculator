package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.network.LoveModel

class LoveViewModel : ViewModel() {

    var liveLoveModel: LiveData<LoveModel> = MutableLiveData()

    private val repository = Repository()

    fun fillLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        return repository.getLoveModel(firstName, secondName)
    }

}