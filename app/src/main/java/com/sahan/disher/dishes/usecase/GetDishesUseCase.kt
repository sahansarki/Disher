package com.sahan.disher.dishes.usecase

import com.sahan.disher.dishes.model.DishesResponse
import com.sahan.disher.dishes.repository.IDishesRepository
import javax.inject.Inject


interface IGetDishesUseCase {

    suspend operator fun invoke(categoryName: String): DishesResponse

}

class GetDishesUseCase @Inject constructor(
    private val repo: IDishesRepository
) : IGetDishesUseCase {
    override suspend fun invoke(categoryName: String): DishesResponse {
        return repo.getDishesForCategory(categoryName)
    }
}
