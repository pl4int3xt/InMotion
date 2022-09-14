package com.example.inmotion.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.inmotion.common.Constants
import com.example.inmotion.presentation.Screen
import com.example.inmotion.presentation.coin_details.components.CoinDetailScreen
import com.example.inmotion.presentation.coin_list.components.CoinListScreen

@Composable
fun MainNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.CoinListScreen.route
    ){
        composable(route = Screen.CoinListScreen.route){
            CoinListScreen(navHostController = navHostController)
        }
        composable(
            route = Screen.CoinDataDetailScreen.route + "/{coinId}",
        ){
            CoinDetailScreen(navHostController = navHostController)
        }
    }
}