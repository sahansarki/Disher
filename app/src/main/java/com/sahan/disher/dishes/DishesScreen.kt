package com.sahan.disher.dishes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.sahan.disher.dishes.model.Meal
import com.sahan.disher.dishes.viewmodel.DishesScreenState
import com.sahan.disher.dishes.viewmodel.DishesViewModel

@Composable
fun DishesScreen(
    viewModel: DishesViewModel = hiltViewModel(),
    category: String?
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

    val viewState by remember {
        viewModel.dishesScreenState
    }
    //val viewState = viewModel.dishesScreenState.value

    when(viewState) {
        is DishesScreenState.Success<*> -> {
            Text(text = "Success ${(viewState as DishesScreenState.Success<*>).data}")
        }

        is DishesScreenState.Error -> {
            Text(text = "Success ${(viewState as DishesScreenState.Error).errorMessage}")
        }
        else -> {
            Text(text = "Loading")
        }
    }

}