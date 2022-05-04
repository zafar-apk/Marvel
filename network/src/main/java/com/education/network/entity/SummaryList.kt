package com.education.network.entity


import com.google.gson.annotations.SerializedName

data class SummaryList(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<CommonSummary?>?,
    @SerializedName("returned")
    val returned: Int?
)