package com.sahan.disher.dishes.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahan.disher.dishes.model.Meal
import com.sahan.disher.dishes.usecase.IGetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getDishesUseCase: IGetDishesUseCase
): ViewModel() {

    private val _dishesScreenState: MutableState<DishesScreenState> = mutableStateOf(DishesScreenState.Loading)
    val dishesScreenState: State<DishesScreenState>
        get() = _dishesScreenState

    fun getDishesForCategory(catName: String) {
        viewModelScope.launch {
            try {
                val listDishes = getDishesUseCase(catName)
                _dishesScreenState.value = DishesScreenState.Success(listDishes.meals)
            } catch (e: Exception) {
                _dishesScreenState.value = DishesScreenState.Error(e.localizedMessage ?: "Unknown error sad moment")
            }

        }
    }
}