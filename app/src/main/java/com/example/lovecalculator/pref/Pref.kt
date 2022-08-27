package com.example.lovecalculator.pref

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.lovecalculator.consts.Const.PREF_NAME

class Pref(private val context: Context) {

    fun saveShown() {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().putBoolean("isShown", true)
            .commit()
    }

    fun isShown(): Boolean {
        return context.getSharedPreferences(PREF_NAME, MODE_PRIVATE).getBoolean("isShown", false)
    }

}