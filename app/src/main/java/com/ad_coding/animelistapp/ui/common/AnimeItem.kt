package com.ad_coding.animelistapp.ui.common

import AnimeData
import AttributesDto
import CoverImageDto
import LinksDto
import RelationshipsDto
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberImagePainter


@Composable
fun AnimeItem(
    modifier: Modifier = Modifier,
    anime: AnimeData
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        anime.attributes.coverImage?.large?.let { imageUrl ->
            CharacterImage(
                imageUrl = imageUrl,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview
@Composable
private fun ShowAnimeItem() {
    AnimeItem(
        anime = AnimeData(
            id = "1",
            type = "anime",
            links = LinksDto("/anime/7442"),
            attributes = AttributesDto(
                coverImage = CoverImageDto(
                    large = "https://media.kitsu.app/anime/cover_images/7442/large.jpg"
                )
            ),
            relationships = RelationshipsDto()
        )
    )
}

@Composable
fun CharacterImage(imageUrl: String, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "Character image",
        modifier = modifier,
        loading = { },
        contentScale = ContentScale.Crop
    )
}