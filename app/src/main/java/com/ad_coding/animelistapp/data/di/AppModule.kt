package com.ad_coding.animelistapp.data.di

import com.ad_coding.animelistapp.data.network.KitsuApi
import com.ad_coding.animelistapp.data.repository.TrendingAnimeRepositoryImpl
import com.ad_coding.animelistapp.domain.repository.TrendingAnimeRepository
import com.ad_coding.animelistapp.utils.AppLogger
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    fun provideLogger(): AppLogger = AppLogger

    @Singleton
    @Provides
    fun provideKitsuApi(moshi: Moshi): KitsuApi =
        Retrofit.Builder()
            .baseUrl(KitsuApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
            .create(KitsuApi::class.java)

    @Singleton
    @Provides
    fun provideTrendingAnimeRepository(api: KitsuApi): TrendingAnimeRepository =
        TrendingAnimeRepositoryImpl(api)
}