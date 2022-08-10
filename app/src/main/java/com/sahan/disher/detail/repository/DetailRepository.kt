package com.sahan.disher.detail.repository

import com.sahan.disher.detail.model.MealDetailResponse
import com.sahan.disher.detail.service.IDetailService
import javax.inject.Inject

interface IDetailRepository {
    suspend fun getDetailsForDishes(id: String): MealDetailResponse

}

class DetailRepository @Inject constructor(
    private val service: IDetailService
): IDetailRepository {
    override suspend fun getDetailsForDishes(id: String): MealDetailResponse {
        return service.getDetailsForDish(id)
    }

}