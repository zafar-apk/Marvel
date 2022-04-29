package com.education.marvel.data.entity.comic

import com.google.gson.annotations.SerializedName
import java.util.*

data class ComicDate(
    @SerializedName("type") val type: String?,
    @SerializedName("date") val date: Date?
)
