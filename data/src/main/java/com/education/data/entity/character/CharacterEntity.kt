package com.education.data.entity.character

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.education.data.db.DateConverter
import com.education.data.db.SummaryConverter
import com.education.domain.entity.Image
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