package com.example.inmotion.domain.repository

import com.example.inmotion.data.remote.dto.CoinDetailDto
import com.example.inmotion.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}