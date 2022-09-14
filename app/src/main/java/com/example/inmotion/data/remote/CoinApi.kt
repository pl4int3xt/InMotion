package com.example.inmotion.data.remote

import com.example.inmotion.data.remote.dto.CoinDetailDto
import com.example.inmotion.data.remote.dto.CoinDto
import com.example.inmotion.domain.models.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto
}