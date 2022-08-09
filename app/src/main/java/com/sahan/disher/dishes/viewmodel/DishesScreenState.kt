package com.sahan.disher.dishes.viewmodel

sealed class DishesScreenState {
    object Loading: DishesScreenState()
    data class Success<T>(val data: T): DishesScreenState()
    data class Error(val errorMessage: String): DishesScreenState()

}

/**
 * Loading
 * Success
 * Error
 */
