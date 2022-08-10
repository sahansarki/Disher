package com.sahan.disher.detail.usecase

import com.sahan.disher.detail.model.MealDetailResponse
import com.sahan.disher.detail.repository.IDetailRepository
import javax.inject.Inject

interface IGetDetailUseCase {
    suspend operator fun invoke(id: String): MealDetailResponse
}

class GetDetailUseCase @Inject constructor(
    private val repo: IDetailRepository
): IGetDetailUseCase {
    override suspend fun invoke(id: String): MealDetailResponse {
        return repo.getDetailsForDishes(id)
    }
}