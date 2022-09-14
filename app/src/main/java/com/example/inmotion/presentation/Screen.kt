package com.example.inmotion.presentation

sealed class Screen(val route: String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDataDetailScreen: Screen("coin_detail_screen")
}
