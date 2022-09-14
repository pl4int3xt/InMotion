package com.example.inmotion.presentation.coin_list

import com.example.inmotion.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
