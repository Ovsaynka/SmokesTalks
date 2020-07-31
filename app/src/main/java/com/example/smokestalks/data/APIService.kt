package com.example.smokestalks.data

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/categories")
    fun getCategories(): Call<List<Category>>
}