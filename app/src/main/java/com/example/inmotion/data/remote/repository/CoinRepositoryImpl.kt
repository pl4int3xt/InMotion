package com.example.inmotion.data.remote.repository

import com.example.inmotion.data.remote.CoinApi
import com.example.inmotion.data.remote.dto.CoinDetailDto
import com.example.inmotion.data.remote.dto.CoinDto
import com.example.inmotion.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinApi.getCoinById(coinId)
    }
}