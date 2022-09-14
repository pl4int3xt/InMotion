package com.example.inmotion.di

import com.example.inmotion.common.Constants
import com.example.inmotion.data.remote.CoinApi
import com.example.inmotion.data.remote.repository.CoinRepositoryImpl
import com.example.inmotion.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCoinApi(): CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCoinRepository(coinApi: CoinApi): CoinRepository{
        return CoinRepositoryImpl(coinApi)
    }
}