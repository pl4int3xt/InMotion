package com.example.inmotion.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.inmotion.presentation.components.MainNavGraph
import com.example.inmotion.presentation.ui.theme.InMotionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InMotionTheme {
                val navHostController = rememberNavController()
                MainNavGraph(navHostController = navHostController)
            }
        }
    }
}