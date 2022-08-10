package com.sahan.disher.detail.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahan.disher.detail.model.Meal
import com.sahan.disher.detail.model.MealDetailResponse
import com.sahan.disher.detail.usecase.IGetDetailUseCase
import com.sahan.disher.dishes.viewmodel.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val getDetailUseCase: IGetDetailUseCase
): ViewModel() {

    private val _meal: MutableState<Meal?> = mutableStateOf(null)
    val meal: State<Meal?>
        get() = _meal

    fun getDetailsForDishes(id: String) {
        Log.d("BK", "$id")
        viewModelScope.launch {
            try {
                val mealDetailResponse = getDetailUseCase(id)
                Log.d("BK", "${mealDetailResponse.meals[0].strMeal}")
                _meal.value = mealDetailResponse.meals[0]
            } catch (e: Exception) {
                Log.d("BK", "Exception ${e.localizedMessage}")
            }

        }
    }
}