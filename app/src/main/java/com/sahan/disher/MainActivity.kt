package com.sahan.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.sahan.disher.category.CategoryScreen
import com.sahan.disher.dishes.DishesScreen
import com.sahan.disher.ui.theme.DisherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                DisherApp()
            }
        }
    }
}

@Composable
fun DisherApp() {
    /**
     * split this NavHost
     * composables -cs
     * composables - DishesScreen
     */

    val navComtroller = rememberNavController()
    //CategoryScreen()
    NavHost(navController = navComtroller, startDestination = "category") {
        composable("category") {
            //navComtroller.navigate("dishes")
            CategoryScreen(onItemClick = { category ->
                navComtroller.navigate(route = "dishes/${category}")
            })
        }

        composable("dishes/{category}", arguments = listOf(navArgument("category") {
             type = NavType.StringType
        })) {
            // it holds a little bit of memory every time this block gets recomposed.This remember will at least have like this sort of fake caching system.
            val categoryStr = remember {
                it.arguments?.getString("category")
            }

            DishesScreen(category = categoryStr)
        }
    }
    //DishesScreen
}

