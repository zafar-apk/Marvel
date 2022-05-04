package com.education.marvel.data.entity.character

import com.education.marvel.data.entity.NetworkImage
import com.education.marvel.data.entity.SummaryList
import com.google.gson.annotations.SerializedName
import java.util.*

data class CharacterNetwork(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("modified")
    val modified: Date?,
    @SerializedName("resourceURI")
    val resUrl: String?,
    @SerializedName("thumbnail")
    val thumbnail: NetworkImage?,
    @SerializedName("comics")
    val comics: SummaryList,
    @SerializedName("stories")
    val stories: SummaryList,
    @SerializedName("events")
    val events: SummaryList,
    @SerializedName("series")
    val series: SummaryList
)