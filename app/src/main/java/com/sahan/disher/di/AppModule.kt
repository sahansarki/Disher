package com.sahan.disher.di

import com.sahan.disher.category.repository.CategoryRepository
import com.sahan.disher.category.repository.ICategoryRepository
import com.sahan.disher.category.usecase.GetCategoriesUseCase
import com.sahan.disher.category.usecase.IGetCategoriesUseCase
import com.sahan.disher.dishes.repository.DishesRepository
import com.sahan.disher.dishes.repository.IDishesRepository
import com.sahan.disher.dishes.service.IDishesService
import com.sahan.disher.dishes.usecase.GetDishesUseCase
import com.sahan.disher.dishes.usecase.IGetDishesUseCase
import com.sahan.disher.category.service.ICategoryService
import com.sahan.disher.detail.repository.DetailRepository
import com.sahan.disher.detail.repository.IDetailRepository
import com.sahan.disher.detail.service.IDetailService
import com.sahan.disher.detail.usecase.GetDetailUseCase
import com.sahan.disher.detail.usecase.IGetDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit): ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishesService(retrofit: Retrofit): IDishesService {
        return retrofit.create(IDishesService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailService(retrofit: Retrofit): IDetailService {
        return retrofit.create(IDetailService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideGetDetailRepository(repo: DetailRepository): IDetailRepository

        @Binds
        @Singleton
        fun provideGetDetailUseCases(uc: GetDetailUseCase): IGetDetailUseCase

        @Binds
        @Singleton
        fun provideDishesRepository(repo: DishesRepository): IDishesRepository

        @Binds
        @Singleton
        fun provideGetDishesUseCases(uc: GetDishesUseCase): IGetDishesUseCase

        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCases(uc: GetCategoriesUseCase): IGetCategoriesUseCase

    }
}