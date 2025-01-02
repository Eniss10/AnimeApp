package com.ad_coding.animelistapp.domain.repository

import AnimeData


interface TrendingAnimeRepository {
    suspend fun getTrendingAnime(): List<AnimeData>
}