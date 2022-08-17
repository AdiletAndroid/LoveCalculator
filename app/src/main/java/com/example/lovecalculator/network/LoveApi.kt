package com.example.lovecalculator.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateLove(
        @Header("X-RapidAPI-Key") key: String = "8c8e457f7cmshd35d719a6679cb2p1df82ajsn69cf0072c2b6",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
        @Query("sname") secondName: String,
        @Query("fname") firstName: String,
    ): Call<LoveModel>

}