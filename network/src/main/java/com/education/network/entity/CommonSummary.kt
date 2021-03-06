package com.education.network.entity

import com.google.gson.annotations.SerializedName

data class CommonSummary(
    @SerializedName("resourceURI") val resUrl: String?,
    @SerializedName("name") val name: String?
)