package com.example.inmotion.presentation.coin_details

import com.example.inmotion.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
