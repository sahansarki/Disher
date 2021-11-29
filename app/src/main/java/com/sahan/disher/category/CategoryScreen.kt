package com.sahan.disher.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sahan.disher.category.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(
    viewmodel: CategoryViewModel = hiltViewModel()
){
    val categories = getFakeData()
    Column {
        Text("Category")
        Spacer(modifier = Modifier.height(30.dp))
        categories.forEach {
            Text(text = it)
        }
    }
}

fun getFakeData(): List<String> {
    return listOf(
        "Fish",
        "Vegan",
        "Meat"
    )
}