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
    private var _animes = MutableStateFlow<List<AnimeData>>(emptyList())
    val animes = _animes.asStateFlow()
    private var _clickedItem = MutableStateFlow<Boolean>(false)
    private var animeList : List<AnimeData> ? = null

    init {
        observerLastClickedAnimeId()

        viewModelScope.launch {
            animeList = repository.getTrendingAnime()
            _animes.update { animeList!! }
            logger.log("[viewModelScope]: anime list fetched")
        }

    }

    private fun observerLastClickedAnimeId() {
        viewModelScope.launch {
            _clickedItem.collect {
                if (_clickedItem.value) {
                    handleAnimeChange()
                    _clickedItem.update { false }
                }
            }
        }
    }

    private fun handleAnimeChange() {
        viewModelScope.launch {
            _animes.update { animeList!! }
            logger.log("[viewModelScope]: anime list updated")
        }
    }

    fun updateLastClickedAnimeId(animeId: String) {
       animeList =  animeList?.map { animeData ->
            if(animeData.id == animeId) {
                animeData.copy(payload = animeData.payload.copy(isFavorite = !animeData.payload.isFavorite))
            } else {
                animeData
            }
        }
        _clickedItem.update { true }
    }
}