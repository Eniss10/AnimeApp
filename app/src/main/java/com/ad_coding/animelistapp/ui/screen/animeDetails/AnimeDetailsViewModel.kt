package com.ad_coding.animelistapp.ui.screen.animeDetails

import AnimeData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad_coding.animelistapp.utils.AppLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(): ViewModel() {
    private var _showAnimeDetailsFragment = MutableStateFlow<Boolean>(false)
    val showAnimeDetailsFragment: StateFlow<Boolean> = _showAnimeDetailsFragment.asStateFlow()
    private var _actualAnime = MutableStateFlow<AnimeData?>(null)
    val actualAnime: StateFlow<AnimeData?> = _actualAnime.asStateFlow()

    fun updateShowAnimeDetailsFragment(show: Boolean, actualAnime: AnimeData?)  {
        viewModelScope.launch {
            _showAnimeDetailsFragment.emit(show)
        }
        if(actualAnime != null) {
            viewModelScope.launch {
                AppLogger.log("[updateShowAnimeDetailsFragment]: ${actualAnime.attributes.titles?.en}")
                _actualAnime.emit(actualAnime)
            }
        }
    }
}
