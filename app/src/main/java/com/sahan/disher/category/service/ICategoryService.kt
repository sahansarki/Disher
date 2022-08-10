package com.sahan.disher.category.service

import com.sahan.disher.category.model.CategoryResponse
import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}