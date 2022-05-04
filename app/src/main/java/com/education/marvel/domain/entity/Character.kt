package com.education.marvel.domain.entity

import java.util.*


data class Character(
    val id: Int?,
    val name: String?,
    val description: String?,
    val modified: Date?,
    val thumbnail: Image?,
    val details: List<String>?,
    val page: Int,
    val modifiedFormatted: String = ""
)