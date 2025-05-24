package com.ad_coding.animelistapp.ui.screen.trendinganime

import AnimeData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ad_coding.animelistapp.ui.common.AsyncImage
import com.ad_coding.animelistapp.utils.Constants
import com.ad_coding.animelistapp.utils.ImageSize
import com.ad_coding.animelistapp.utils.ImageType
import com.ad_coding.animelistapp.utils.getCoverUrl
import com.ad_coding.animelistapp.utils.getPosterUrl

@Composable
fun AnimeList(
    animes: List<AnimeData>,
    trendingAnimeViewModel: TrendingAnimeViewModel,
    itemClickListener: (AnimeData) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(Constants.VERTICAL_GRID_COLUMNS),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        contentPadding = PaddingValues(Constants.VERTICAL_GRID_PADDING),
        verticalArrangement = Arrangement.spacedBy(Constants.VERTICAL_GRID_PADDING),
        horizontalArrangement = Arrangement.spacedBy(Constants.VERTICAL_GRID_PADDING)
    )
    {
        item(span = { GridItemSpan(2) }) {
            ItemImage(
                data = animes.first(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(10.dp)),
                imageType = ImageType.Cover,
                trendingAnimeViewModel = trendingAnimeViewModel,
                itemClickListener = itemClickListener

            )
        }
        val newList = animes.drop(0)
        items(newList.size) { index ->
            ItemImage(
                data = animes[index], imageType = ImageType.Poster,
                trendingAnimeViewModel = trendingAnimeViewModel,
                itemClickListener = itemClickListener
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ItemImage(
    modifier: Modifier = Modifier,
    data: AnimeData,
    imageType: ImageType,
    trendingAnimeViewModel: TrendingAnimeViewModel,
    itemClickListener: (AnimeData) -> Unit
) {
    val onClick = {
        trendingAnimeViewModel.updateLastClickedAnimeId(data.id)
        println("hello  anime ${data.attributes.titles?.en_jp} is clicked: ${data.payload.isClicked}")
    }

    val imageUrl = when(imageType) {
        ImageType.Cover -> data.getCoverUrl(ImageSize.Large)
        ImageType.Poster -> data.getPosterUrl(ImageSize.Original)
    }

    Box(modifier = modifier
        .width(200.dp)
        .height(200.dp)
        .clip(
            RoundedCornerShape(
                10.dp
            )
        )) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            imageUrl = imageUrl!!,
            imageType = imageType,
            itemClickListener= itemClickListener,
            data = data
        )
    }
}