package com.sahan.disher.category.usecase

import com.sahan.disher.category.repository.ICategoryRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {

    suspend operator fun invoke(): String

}

class GetCategoriesUseCase @Inject constructor(
    val repo: ICategoryRepository
) : IGetCategoriesUseCase {

    override suspend fun invoke(): String {
        return repo.getAllCategories()
    }

}