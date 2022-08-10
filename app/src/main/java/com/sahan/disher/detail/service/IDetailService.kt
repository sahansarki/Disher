package com.sahan.disher.detail.service

import com.sahan.disher.detail.model.MealDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDetailService {
    @GET("lookup.php")
    suspend fun getDetailsForDish(
        @Query("i") mealId: String
    ): MealDetailResponse
}