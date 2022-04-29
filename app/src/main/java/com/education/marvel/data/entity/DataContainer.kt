package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class DataContainer<T>(
    @SerializedName("offset") val offset: Int?,
    @SerializedName("limit") val limit: Int?,
    @SerializedName("total") val total: Int?,
    @SerializedName("count") val count: Int?,
    @SerializedName("results") val results: List<T>?
)