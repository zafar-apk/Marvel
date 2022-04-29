package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class StorySummary(
    @SerializedName("resourceURI") val resUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?
)