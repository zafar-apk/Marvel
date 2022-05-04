package com.education.data.entity.character

import com.google.gson.annotations.SerializedName

data class CharactersDataWrapper(
    @SerializedName("code") val code: Int?,
    @SerializedName("status") val status: String?,
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("attributionText") val attributionText: String?,
    @SerializedName("attributionHTML") val attributionHTML: String?,
    @SerializedName("data") val `data`: CharacterDataContainer?,
    @SerializedName("etag") val eTag: String?
)