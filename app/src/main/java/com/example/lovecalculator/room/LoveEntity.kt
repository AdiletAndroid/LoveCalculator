package com.example.lovecalculator.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Love_model")
data class LoveEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val firstName: String,
    val secondName: String,
    val percentage: String,
    val result: String,
)