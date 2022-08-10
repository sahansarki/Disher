package com.sahan.disher.dishes.viewmodel

import com.sahan.disher.dishes.model.Meal

sealed class ViewState {
    object Loading: ViewState()
    data class Success(val data: List<Meal>): ViewState()
    data class Error(val errorMessage: String): ViewState()

}

/**
 * Loading
 * Success
 * Error
 */
