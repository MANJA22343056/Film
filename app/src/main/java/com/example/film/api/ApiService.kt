package com.example.film.api

import com.example.film.ResponseMorty
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getMorty(): Call<ResponseMorty>
}