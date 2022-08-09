package com.sahan.disher.category.repository

import com.sahan.disher.category.model.CategoryResponse
import com.sahan.disher.service.ICategoryService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    private val service: ICategoryService
) : ICategoryRepository{
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }

}