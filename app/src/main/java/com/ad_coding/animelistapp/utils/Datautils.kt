package com.ad_coding.animelistapp.utils

import AnimeData

enum class ImageSize {
    Small,
    Medium,
    Large,
    Original
}

enum class ImageType {
    Cover,
    Poster
}

fun AnimeData.getPosterUrl(size: ImageSize): String? {
   return when (size) {
       ImageSize.Small -> attributes.posterImage?.small.toString() ?: null
       ImageSize.Medium -> attributes.posterImage?.medium.toString() ?: null
       ImageSize.Large -> attributes.posterImage?.large.toString() ?: null
       ImageSize.Original -> attributes.posterImage?.original.toString() ?: null
   }
}

fun AnimeData.getCoverUrl(size: ImageSize): String? {
    return when (size) {
        ImageSize.Small -> attributes.coverImage?.small.toString() ?: null
        ImageSize.Large -> attributes.coverImage?.large.toString() ?: null
        ImageSize.Original -> attributes.coverImage?.original.toString() ?: null
        else -> null
    }
}
