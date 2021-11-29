package com.sahan.disher.service

import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.php")
    suspend fun getAllCategories(): String
}