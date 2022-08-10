package com.sahan.disher.detail

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.sahan.disher.detail.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    mealID: String?
) {
    
    // SIDE EFFECT
    // its unit because we are not interested in actually listening something that changes
    DisposableEffect(key1 = Unit) {
        if (!mealID.isNullOrBlank()) {
            viewModel.getDetailsForDishes(mealID)
        }
        onDispose {  }

    }
    
    val singleDish by remember {
        viewModel.meal
    }
    
    singleDish?.let { 
        Text(text = it.strMeal)
    }

    // collect the state
}