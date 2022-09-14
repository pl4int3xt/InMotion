package com.example.inmotion.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inmotion.common.Resource
import com.example.inmotion.domain.use_case.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        val coinId = savedStateHandle.get<String>("coinId")?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success->{
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error->{
                    _state.value = CoinDetailState(error = result.message ?: "")
                }
                is Resource.Loading->{
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }
    }
}