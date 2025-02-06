package com.example.simplemeal.data.remote

import com.example.simplemeal.data.remote.response.CategoriesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}