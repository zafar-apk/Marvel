package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseList<T>(
    @SerializedName("available") val available: Int?,
    @SerializedName("returned") val returned: Int?,
    @SerializedName("collectionUri") val collectionUri: String?,
    @SerializedName("items") val items: List<T>?,
)