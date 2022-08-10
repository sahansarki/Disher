package com.sahan.disher.dishes.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahan.disher.dishes.usecase.IGetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val getDishesUseCase: IGetDishesUseCase
): ViewModel() {

    private val _dishesScreenState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val dishesScreenState: State<ViewState>
        get() = _dishesScreenState

    fun getDishesForCategory(catName: String) {
        _dishesScreenState.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val listDishes = getDishesUseCase(catName)
                _dishesScreenState.value = ViewState.Success(listDishes.meals)
            } catch (e: Exception) {
                _dishesScreenState.value = ViewState.Error(e.localizedMessage ?: "Unknown error sad moment")
            }

        }
    }
}