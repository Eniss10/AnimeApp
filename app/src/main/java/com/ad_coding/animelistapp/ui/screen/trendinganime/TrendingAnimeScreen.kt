package com.ad_coding.animelistapp.ui.screen.trendinganime

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ad_coding.animelistapp.ui.screen.animeDetails.AnimeDetailsViewModel

@Composable
fun TrendingAnimeScreen(
    trendingAnimeViewModel: TrendingAnimeViewModel = hiltViewModel(),
    animeDetailsFragmentViewModel: AnimeDetailsViewModel = hiltViewModel(),
) {
    val animeData by trendingAnimeViewModel.animes.collectAsStateWithLifecycle()
    val showDialog by animeDetailsFragmentViewModel.showAnimeDetailsFragment.collectAsStateWithLifecycle()

    val itemClickListener = { animeDetailsFragmentViewModel.updateShowAnimeDetailsFragment(true) }

    if (animeData.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimeList(
                animes = animeData,
                trendingAnimeViewModel = trendingAnimeViewModel,
                itemClickListener = itemClickListener
            )
            if (showDialog) {
                DialogOverlay { animeDetailsFragmentViewModel.updateShowAnimeDetailsFragment(false) }
            }
        }
    } else {
       // Todo: implement an alternative
    }
}

@Composable
fun DialogOverlay(onDismiss: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black.copy(alpha = 0.5f))
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onDismiss
        )
    )
    {
        // TODO: implement a dialog that shows animedata


    }
}