package com.ad_coding.animelistapp.data.network

import AnimeResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface KitsuApi {
    @GET("trending/anime")
    suspend fun getTrendingAnime(): ApiResponse<AnimeResponse>

    companion object {
        const val BASE_URL = "https://kitsu.io/api/edge/"
    }
}