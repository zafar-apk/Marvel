package com.education.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.education.data.entity.character.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun dao(): CharacterDao
}