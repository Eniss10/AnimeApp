package com.ad_coding.animelistapp.ui.screen.trendinganime.overlay

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ad_coding.animelistapp.ui.screen.animeDetails.AnimeDetailsViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun DialogOverlay(
    onDismiss: () -> Unit,
    animeDetailsFragmentViewModel: AnimeDetailsViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onDismiss
            )
    ) {
        val actualAnimeDisplayValue by animeDetailsFragmentViewModel.actualAnime.collectAsStateWithLifecycle()
        val context = LocalContext.current
        val youtubeVideoId = actualAnimeDisplayValue?.attributes?.youtubeVideoId
        val youtubeUrl = "https://www.youtube.com/watch?v=$youtubeVideoId"

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(Color.White)
            ) {
                Column {
                    Text(
                        text =actualAnimeDisplayValue?.attributes?.titles?.en.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        color = MaterialTheme.colorScheme.primary,
                    )

                    if (!youtubeVideoId.isNullOrEmpty()) {
                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
                                context.startActivity(intent)
                            },
                            modifier = Modifier.padding(top = 16.dp).align(Alignment.CenterHorizontally)
                        ) {
                            Text("Watch Preview")
                        }
                    }

                }

            }
        }
    }
}

