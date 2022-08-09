package com.sahan.disher.dishes.repository

import com.sahan.disher.dishes.model.DishesResponse
import com.sahan.disher.dishes.service.IDishesService
import javax.inject.Inject

interface IDishesRepository {
    suspend fun getDishesForCategory(categoryName: String): DishesResponse
}

class DishesRepository @Inject constructor(
    private val service: IDishesService
): IDishesRepository {
    override suspend fun getDishesForCategory(categoryName: String): DishesResponse {
        return service.getDishesForCategory(categoryName)
    }
}