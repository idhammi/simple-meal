package com.example.simplemeal.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.simplemeal.ui.screen.HomeScreen
import com.example.simplemeal.ui.theme.SimpleMealTheme

class MainActivity : ComponentActivity() {
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.attributes.preferredRefreshRate = 120f
        enableEdgeToEdge()
        setContent {
            SimpleMealTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}