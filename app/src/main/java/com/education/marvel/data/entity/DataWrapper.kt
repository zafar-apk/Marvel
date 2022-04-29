package com.education.marvel.data.entity

import com.google.gson.annotations.SerializedName

data class DataWrapper<T>(
    @SerializedName("code") val code: Int?,
    @SerializedName("status") val status: Int?,
    @SerializedName("copyright") val copyright: String?,
    @SerializedName("attributionText") val attributionText: String?,
    @SerializedName("attributionHTML") val attributionHTML: String?,
    @SerializedName("data") val data: T?,
    @SerializedName("etag") val eTag: String?
)