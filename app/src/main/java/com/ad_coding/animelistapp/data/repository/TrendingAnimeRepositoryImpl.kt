package com.ad_coding.animelistapp.data.repository


import AnimeData
import com.ad_coding.animelistapp.data.network.KitsuApi
import com.ad_coding.animelistapp.domain.repository.TrendingAnimeRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class TrendingAnimeRepositoryImpl @Inject constructor(
    val api: KitsuApi
):TrendingAnimeRepository {
    override suspend fun getTrendingAnime(): List<AnimeData> {
        var result: List<AnimeData>? = null
        api.getTrendingAnime().onSuccess {
            result = data.data
        }
            .onError {  }
            .onException {  }
        return result!!
    }
}