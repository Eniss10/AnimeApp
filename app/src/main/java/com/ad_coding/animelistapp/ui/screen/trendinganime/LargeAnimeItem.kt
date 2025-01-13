package com.ad_coding.animelistapp.ui.screen.trendinganime

import AnimeData
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ad_coding.animelistapp.ui.common.AsyncImage

@Composable
fun LargeAnimeItem(
    modifier: Modifier,
    bannerAnime: AnimeData,
) {
    Column {
        BannerAnime(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            bannerAnime = bannerAnime
        )
    }
}

@Composable
fun BannerAnime(
    modifier: Modifier = Modifier, bannerAnime: AnimeData
) {
    Column {
        Box(modifier = modifier) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth().padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .height(300.dp)
                    .clip(RoundedCornerShape(12.dp)),
                imageUrl = bannerAnime.attributes.coverImage?.large.toString()
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                fontSize = 20.sp,
                text = bannerAnime.attributes.canonicalTitle.toString(),
                color = Color.Black,
                modifier = Modifier.fillMaxWidth().padding(start = 25.dp, top = 10.dp),
                fontWeight = FontWeight.Bold
            )
        }

    }

}