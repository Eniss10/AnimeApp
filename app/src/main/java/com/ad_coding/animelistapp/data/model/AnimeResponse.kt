import kotlinx.serialization.Serializable

data class AnimeResponse(
    val data: List<AnimeData>
)

data class AnimeData(
    val id: String,
    val type: String,
    val links: LinksDto,
    val attributes: AttributesDto,
    val relationships: RelationshipsDto
)

data class AttributesDto(
    val createdAt: String,
    val updatedAt: String,
    val slug: String?,
    val synopsis: String?,
    val coverImageTopOffset: Int,
    val titles: TitlesDto,
    val canonicalTitle: String?,
    val abbreviatedTitles: List<String>,
    val averageRating: String?,
    val ratingFrequencies: Map<String,String>,
    val userCount: Int?,
    val favoritesCount: Int?,
    val startDate: String?,
    val endDate: String?,
    val popularityRank: Int?,
    val ratingRank: Int?,
    val ageRating: String?,
    val ageRatingGuide: String?,
    val subtype: String,
    val status: String,
    val tba: String?,
    val posterImage: PosterImageDto,
    val coverImage: CoverImageDto,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val youtubeVideoId: String?,
    val showType: String?,
    val nsfw: Boolean
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
    val tiny: String,
    val small: String,
    val large: String,
    val original: String,
    val meta: MetaDto?
)

data class RelationshipsDto(
    val genres: RelationDto,
    val categories: RelationDto,
    val castings: RelationDto,
    val installments: RelationDto,
    val mappings: RelationDto,
    val reviews: RelationDto,
    val mediaRelationships: RelationDto,
    val episodes: RelationDto,
    val streamingLinks: RelationDto,
    val animeProductions: RelationDto,
    val animeCharacters: RelationDto,
    val animeStaff: RelationDto
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