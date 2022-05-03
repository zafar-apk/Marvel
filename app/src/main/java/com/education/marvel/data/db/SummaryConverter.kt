package com.education.marvel.data.db

import androidx.room.TypeConverter

class SummaryConverter {

    @TypeConverter
    fun toSummaryList(string: String) = string.split("|")

    @TypeConverter
    fun fromSummaryList(summaries: List<String>) = buildString {
        summaries.forEachIndexed { index, item ->
            append(item)
            if (index != lastIndex) {
                append('|')
            }
        }
    }
}