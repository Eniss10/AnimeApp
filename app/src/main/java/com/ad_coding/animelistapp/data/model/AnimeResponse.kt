import kotlinx.serialization.Serializable

data class AnimeResponse(
    val data: List<AnimeData>
)

data class AnimeTile(
    var isClicked: Boolean = false,
    var isFavorite: Boolean = false,
    var isLiked: Boolean = false,
    var isSaved: Boolean = false,
    var isWatched: Boolean = false,
)

data class AnimeData(
    val id: String,
    val type: String,
    val links: LinksDto,
    val attributes: AttributesDto,
    val relationships: RelationshipsDto,
    val payload: AnimeTile = AnimeTile()
)

data class AttributesDto(
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val slug: String? = null,
    val synopsis: String? = null,
    val coverImageTopOffset: Int? = null,
    val titles: TitlesDto? = null,
    val canonicalTitle: String? = null,
    val abbreviatedTitles: List<String>? = null,
    val averageRating: String? = null,
    val ratingFrequencies: Map<String,String>? = null,
    val userCount: Int? = null,
    val favoritesCount: Int? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val popularityRank: Int? = null,
    val ratingRank: Int? = null,
    val ageRating: String? = null,
    val ageRatingGuide: String? = null,
    val subtype: String? = null,
    val status: String? = null,
    val tba: String? = null,
    val posterImage: PosterImageDto? = null,
    val coverImage: CoverImageDto? = null,
    val episodeCount: Int? = null,
    val episodeLength: Int? = null,
    val youtubeVideoId: String? = null,
    val showType: String? = null,
    val nsfw: Boolean? = null
)

data class TitlesDto(
    val en: String?,
    val en_jp: String?,
    val ja_jp: String?
)

data class PosterImageDto(
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val original: String,
    val meta: MetaDto?
)

data class MetaDto(
    val dimensions: DimensionsDto
)

data class DimensionsDto(
    val tiny: SizeDto,
    val small: SizeDto,
    val large: SizeDto
)

data class SizeDto(
    val width: Int? = null,
    val height: Int? = null
)

data class CoverImageDto(
    val tiny: String ? = null,
    val small: String ? = null,
    val large: String ? = null,
    val original: String ? = null,
    val meta: MetaDto ? = null
)

data class RelationshipsDto(
    val genres: RelationDto ? = null,
    val categories: RelationDto ? = null,
    val castings: RelationDto ? = null,
    val installments: RelationDto ? = null,
    val mappings: RelationDto ? = null,
    val reviews: RelationDto ? = null,
    val mediaRelationships: RelationDto ? = null,
    val episodes: RelationDto ? = null,
    val streamingLinks: RelationDto ? = null,
    val animeProductions: RelationDto ? = null,
    val animeCharacters: RelationDto ? = null,
    val animeStaff: RelationDto ? = null
)

data class RelationDto(
    val links: RelationLinksDto
)

data class LinksDto(
    val self: String
)

data class RelationLinksDto(
    val self: String,
    val related: String
)