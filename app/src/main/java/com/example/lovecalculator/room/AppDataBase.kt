package com.example.lovecalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [LoveEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun loveDao(): LoveDao
}