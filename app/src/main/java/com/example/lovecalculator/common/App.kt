package com.example.lovecalculator.common

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {}