package com.ad_coding.animelistapp.ui.screen.animeDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun updateShowAnimeDetailsFragment(show: Boolean) {
        viewModelScope.launch {
            _showAnimeDetailsFragment.emit(show)
        }
    }
}
