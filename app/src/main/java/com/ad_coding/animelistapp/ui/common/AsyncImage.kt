package com.ad_coding.animelistapp.ui.common

import AnimeData
import AnimeTile
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.ad_coding.animelistapp.utils.ImageType

@Composable
fun AsyncImage(
    modifier: Modifier,
    imageUrl: String,
    imageType: ImageType? = null,
    itemClickListener: (AnimeData) -> Unit,
    data: AnimeData
) {
    var imageLoaded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    itemClickListener.invoke(data)
                },
            loading = { Box(modifier = modifier.shimmerEffect()) },
            onSuccess = { imageLoaded = true},
            contentScale = ContentScale.Crop,
        )
        if (
            imageType!! == ImageType.Cover && imageLoaded
        ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .height(100.dp)
                        .fillMaxWidth()
                ) {
                    InteractionButton(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 40.dp, bottom = 10.dp)
                            .height(50.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.White.copy(alpha = 0.8f)),
                        "Play",
                        clickListener = {println("hello play")}
                    )
                    InteractionButton(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 40.dp, bottom = 10.dp)
                            .height(50.dp)
                            .width(120.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.White.copy(alpha = 0.8f)),
                        "Add", clickListener = {println("hello add")}
                    )
                }
        }
    }
}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(500)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0x00000000),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX,0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ). onGloballyPositioned {
        size = it.size
    }
}

@Composable
fun InteractionButton(
    modifier: Modifier,
    text: String,
    clickListener: () -> Unit
) {
    Box(
        modifier = modifier
    ) {
        Row(
            Modifier
                .fillMaxSize(
                )
                .align(Alignment.Center)
                .clickable {
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}