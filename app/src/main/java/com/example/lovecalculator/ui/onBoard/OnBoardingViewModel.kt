package com.example.lovecalculator.ui.onBoard

import androidx.lifecycle.ViewModel
import com.example.lovecalculator.pref.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val pref: Preferences) : ViewModel() {

    fun saveShown() {
        pref.saveShown()
    }
}