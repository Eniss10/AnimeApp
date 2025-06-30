package com.ad_coding.animelistapp.ui.screen.trendinganime

import AnimeData
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ad_coding.animelistapp.ui.screen.animeDetails.AnimeDetailsViewModel
import com.ad_coding.animelistapp.ui.screen.trendinganime.overlay.DialogOverlay

@Composable
fun TrendingAnimeScreen(
    trendingAnimeViewModel: TrendingAnimeViewModel = hiltViewModel(),
    animeDetailsFragmentViewModel: AnimeDetailsViewModel = hiltViewModel(),
) {
    val animeData by trendingAnimeViewModel.animes.collectAsStateWithLifecycle()
    val showDialog by animeDetailsFragmentViewModel.showAnimeDetailsFragment.collectAsStateWithLifecycle()

    val itemClickListener: (AnimeData) -> Unit =  { anime ->
     animeDetailsFragmentViewModel.updateShowAnimeDetailsFragment(
         show = true,
         actualAnime = anime
     )
    }

    if (animeData.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimeList(
                animes = animeData,
                trendingAnimeViewModel = trendingAnimeViewModel,
                itemClickListener = itemClickListener
            )
            if (showDialog) {
                DialogOverlay (animeDetailsFragmentViewModel = animeDetailsFragmentViewModel,
                    onDismiss = { animeDetailsFragmentViewModel.updateShowAnimeDetailsFragment(false, null) }
                    )
            }
        }
    } else {
    }
}

