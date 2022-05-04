package com.education.marvel.data.entity.character

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.education.marvel.data.db.DateConverter
import com.education.marvel.data.db.SummaryConverter
import com.education.marvel.domain.entity.Image
import java.util.*

const val TABLE_NAME = "character"

@Entity(tableName = TABLE_NAME)
@TypeConverters(DateConverter::class, SummaryConverter::class)
class CharacterEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val description: String?,
    val modified: Date?,
    @Embedded(prefix = "thumbnail")
    val thumbnail: Image?,
    val details: List<String>?,
    val page: Int
)