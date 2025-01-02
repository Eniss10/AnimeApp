package com.ad_coding.animelistapp.ui.screen.trendinganime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TrendingAnimeScreen(
    viewModel: TrendingAnimeViewModel = hiltViewModel()
) {
    val animeData by viewModel.animes.collectAsStateWithLifecycle()
    animeData.forEach {
        println(it.attributes.canonicalTitle.toString())
    }

}