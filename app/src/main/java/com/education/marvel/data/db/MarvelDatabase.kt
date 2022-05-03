package com.education.marvel.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.education.marvel.data.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}