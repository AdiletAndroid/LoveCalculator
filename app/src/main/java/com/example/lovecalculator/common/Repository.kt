package com.example.lovecalculator.common

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.network.LoveApi
import com.example.lovecalculator.network.LoveModel
import com.example.lovecalculator.room.LoveDao
import com.example.lovecalculator.room.LoveEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val loveDao: LoveDao) {

    fun getLoveModel(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val mutableLoveModel: MutableLiveData<LoveModel> = MutableLiveData()

        api.calculateLove(firstName = firstName, secondName = secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        mutableLoveModel.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("ololo", "onFailure:${t.message}")
                }

            })

        return mutableLoveModel
    }

    fun getList(): LiveData<List<LoveEntity>> {
        return loveDao.getAll()
    }
}