package com.ad_coding.animelistapp.ui.screen.trendinganime

import AnimeData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.animelistapp.domain.repository.TrendingAnimeRepository
import com.ad_coding.animelistapp.utils.AppLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingAnimeViewModel @Inject constructor(
    val repository: TrendingAnimeRepository,
    private val logger: AppLogger
): ViewModel() {
    var _animes = MutableStateFlow<List<AnimeData>>(emptyList())
    val animes = _animes.asStateFlow()

    init {
        viewModelScope.launch {
            _animes.update { repository.getTrendingAnime() }
            logger.log("[viewModelScope]: anime list fetched")
        }
    }
}