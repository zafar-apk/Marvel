package com.education.marvel.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class Character(
    @SerializedName("id")
    @PrimaryKey
    val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("modified") val modified: Date?,
    @SerializedName("resourceURI") val resUrl: String?,
    @SerializedName("urls") val urls: List<Url>?,
    @SerializedName("thumbnail") val thumbnail: Image?,
    @SerializedName("comics") val comics: Image?,
)