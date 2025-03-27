package com.ad_coding.animelistapp.ui.screen.trendinganime

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ad_coding.animelistapp.ui.common.AnimeItem

@Composable
fun TrendingAnimeScreen(
    viewModel: TrendingAnimeViewModel = hiltViewModel()
) {
    val animeData by viewModel.animes.collectAsStateWithLifecycle()

    if (animeData.isNotEmpty()) {
        Column {
            AnimeList(
                animes = animeData
            )
        }
    } else {
        Text("Loading or no anime data available")
    }
}