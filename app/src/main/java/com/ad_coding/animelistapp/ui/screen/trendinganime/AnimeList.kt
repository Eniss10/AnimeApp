package com.ad_coding.animelistapp.ui.screen.trendinganime

import AnimeData
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ad_coding.animelistapp.ui.common.AsyncImage
import com.ad_coding.animelistapp.utils.Constants
import com.ad_coding.animelistapp.utils.ImageSize
import com.ad_coding.animelistapp.utils.ImageType
import com.ad_coding.animelistapp.utils.getCoverUrl
import com.ad_coding.animelistapp.utils.getPosterUrl

@Composable
fun AnimeList(
    animes: List<AnimeData>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(Constants.VERTICAL_GRID_COLUMNS),
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
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
                    .height(200.dp),
                imageType = ImageType.Cover
            )
        }
        val newList = animes.drop(0)
        items(newList.size) { index ->
            ItemImage(data = animes[index], imageType = ImageType.Poster)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun ItemImage(
    modifier: Modifier = Modifier,
    data: AnimeData,
    imageType: ImageType
) {
    val imageUrl = when(imageType) {
        ImageType.Cover -> data.getCoverUrl(ImageSize.Original)
        ImageType.Poster -> data.getPosterUrl(ImageSize.Original)
    }

  AsyncImage(
      modifier = modifier.width(200.dp).height(200.dp),
      imageUrl = imageUrl!!
  )
}