@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.ad_coding.animelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalSharedTransitionApi
import com.ad_coding.animelistapp.ui.screen.trendinganime.TrendingAnimeFragment
import com.ad_coding.animelistapp.ui.screen.trendinganime.TrendingAnimeScreen

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TrendingAnimeFragment())
                .commit()
        }
    }
}