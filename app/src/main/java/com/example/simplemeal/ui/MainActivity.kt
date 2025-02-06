package com.example.simplemeal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.simplemeal.ui.screen.Detail
import com.example.simplemeal.ui.screen.DetailScreen
import com.example.simplemeal.ui.screen.Home
import com.example.simplemeal.ui.screen.HomeScreen
import com.example.simplemeal.ui.theme.SimpleMealTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.attributes.preferredRefreshRate = 120f
        enableEdgeToEdge()
        setContent {
            MealApp()
        }
    }
}

@Composable
fun MealApp() {
    val navController = rememberNavController()
    SimpleMealTheme {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            composable<Home> {
                HomeScreen {
                    navController.navigate(
                        Detail(
                            it.strCategory,
                            it.strCategoryDescription,
                            it.strCategoryThumb
                        )
                    )
                }
            }
            composable<Detail> {
                val args = it.toRoute<Detail>()
                DetailScreen(
                    name = args.name,
                    description = args.description,
                    image = args.image
                )
            }
        }
    }
}