package com.example.inmotion.domain.use_case

import com.example.inmotion.common.Resource
import com.example.inmotion.data.remote.dto.toCoin
import com.example.inmotion.domain.models.Coin
import com.example.inmotion.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?:"An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("can't reach server, check your internet connection"))
        }
    }
}