package com.example.lovecalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveEntity)

    @Query("SELECT * FROM love_model ORDER BY firstName, secondName ASC")
    fun getAll(): LiveData<List<LoveEntity>>
}