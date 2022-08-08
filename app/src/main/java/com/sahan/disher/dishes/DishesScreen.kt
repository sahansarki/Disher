package com.sahan.disher.dishes

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DishesScreen(
    category: String?
) {
    Text(text = "The category is $category")
}