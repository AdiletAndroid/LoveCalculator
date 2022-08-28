package com.example.lovecalculator.pref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.lovecalculator.consts.Const.PREF_NAME

class Preferences(private val context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun saveShown() {
        preferences.edit().putBoolean("isShown", true)
            .apply()
    }

    fun isShown(): Boolean {
        return preferences.getBoolean("isShown", false)
    }

}