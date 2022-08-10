package com.sahan.disher.dishes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.sahan.disher.category.SingleItem
import com.sahan.disher.dishes.model.Meal
import com.sahan.disher.dishes.viewmodel.ViewState
import com.sahan.disher.dishes.viewmodel.DishesViewModel

@Composable
fun DishesScreen(
    viewModel: DishesViewModel = hiltViewModel(),
    category: String?,
    onDishClick: (String) -> Unit
) {
    // viewModel.getDishesForCategory() --> we cant do this because every recomposition this function will get called. So we use side effects.
    /**
    side effects : launchedEffect which basically is a side effect of your code that will only re-trigger this block of code in here
    whenever a key changes , you give it a value and say listen to that value and anytime it changes it will re-trigger this launched effect.

    Or there's one that we are going to use thats called disposable effect
    --> its advantage + if the composition the bit of ui that we are writing
    leaves composition if its no longer being composed then sack off this side effect, get rid of it
     */

    DisposableEffect(key1 = Unit) {

        if (!category.isNullOrBlank()) {
            viewModel.getDishesForCategory(category)
        }
        onDispose {
            // when the screen getting cleared away

        }
    }

    val viewStateWithRemember by remember {
        viewModel.dishesScreenState
    }

    when (val viewState = viewStateWithRemember) { // issue is because the class can mutate after the check
        is ViewState.Success -> {
            DishesList(meals = viewState.data, onDishClick)
        }

        is ViewState.Error -> {
            Text(text = "Success ${(viewState).errorMessage}")
        }
        else -> {
            Text(text = "Loading")
        }
    }

}

@Composable
fun DishesList(meals: List<Meal>, onDishClick: (String) -> Unit) {
    LazyColumn {
        items(meals) { item ->
            SingleItem(title = item.strMeal, thumbnail = item.strMealThumb) {
                onDishClick.invoke(item.idMeal)
            }
        }
    }
}

/**
No more do we have the ui holding on to state check.

For example no more like checkbox is checked, no more do those view widgets have that information

no more do we have a view model that says its checked and view saying yes its checked.
no more do we have that two sources of truth.

We only have one source of truth , is it checked and you tell the checkbox you are checked, render accordingly and thats it.
checkbox doesnt know anything its being told you are checked.
 */