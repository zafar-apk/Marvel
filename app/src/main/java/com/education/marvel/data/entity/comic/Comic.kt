package com.education.marvel.data.entity.comic

import com.education.marvel.data.entity.*
import com.google.gson.annotations.SerializedName
import java.util.*

data class Comic(
    @SerializedName("id") val id: Int?,
    @SerializedName("digitalId") val digitalId: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("issueNumber") val issueNumber: Double?,
    @SerializedName("variantDescription") val variantDescription: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: Date?,
    @SerializedName("isbn") val isbn: String?,
    @SerializedName("upc") val upc: String?,
    @SerializedName("diamondCode") val diamondCode: String?,
    @SerializedName("ean") val ean: String?,
    @SerializedName("issn") val issn: String?,
    @SerializedName("format") val format: String?,
    @SerializedName("pageCount") val pageCount: Int?,
    @SerializedName("textObjects") val textObjects: List<TextObject>?,
    @SerializedName("resourceURI") val resourceURI: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("series") val series: CommonSummary?,
    @SerializedName("variants") val variants: List<CommonSummary>?,
    @SerializedName("collections") val collections: List<CommonSummary>?,
    @SerializedName("collectedIssues") val collectedIssues: List<CommonSummary>?,
    @SerializedName("dates") val dates: List<ComicDate>?,
    @SerializedName("prices") val prices: List<ComicPrice>?,
    @SerializedName("thumbnail") val thumbnail: NetworkImage?,
    @SerializedName("images") val networkImages: List<NetworkImage>?,
    @SerializedName("creators") val creators: List<ResponseList<CreatorSummary>>?,
    @SerializedName("characters") val characters: List<ResponseList<Character>>?,
    @SerializedName("stories") val stories: List<ResponseList<StorySummary>>?,
    @SerializedName("events") val events: List<ResponseList<CommonSummary>>?
)
