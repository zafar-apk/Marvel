package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class NetworkImage(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?
)