package com.example.inmotion.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.inmotion.presentation.Screen
import com.example.inmotion.presentation.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navHostController: NavHostController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins){ coin->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navHostController.navigate(Screen.CoinDataDetailScreen.route+"/${coin.id}")}
                )
            }
        }
        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading){
            CircularProgressIndicator( modifier = Modifier.align(Alignment.Center))
        }
    }
}