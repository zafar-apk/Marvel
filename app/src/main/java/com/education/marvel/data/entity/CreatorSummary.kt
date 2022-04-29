package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class CreatorSummary(
    @SerializedName("resourceURI") val resUrl: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("role") val role: String?)
