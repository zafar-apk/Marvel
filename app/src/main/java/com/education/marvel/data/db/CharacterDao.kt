package com.education.marvel.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.education.marvel.data.entity.character.CharacterEntity
import com.education.marvel.data.entity.character.TABLE_NAME
import com.education.marvel.data.source.LocalDataSource

@Dao
interface CharacterDao : LocalDataSource {

    @Insert(onConflict = REPLACE)
    override suspend fun save(vararg characterEntity: CharacterEntity)

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    override suspend fun getById(id: Int): CharacterEntity

    @Query("DELETE FROM $TABLE_NAME")
    override suspend fun clear()

    @Query("SELECT * FROM $TABLE_NAME WHERE page = :page")
    override suspend fun getByPage(page: Int): List<CharacterEntity>
}