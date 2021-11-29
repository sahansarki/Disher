package com.sahan.disher.category.repository

import com.sahan.disher.service.ICategoryService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): String
}

class CategoryRepository @Inject constructor(
    val service: ICategoryService
) : ICategoryRepository{
    override suspend fun getAllCategories(): String {
        return service.getAllCategories()
    }

}