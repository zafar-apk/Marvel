package com.education.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.education.data.entity.character.CharacterEntity
import com.education.data.entity.character.TABLE_NAME

@Dao
interface CharacterDao {

    @Insert(onConflict = REPLACE)
    suspend fun save(vararg characterEntity: CharacterEntity)

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getById(id: Int): CharacterEntity

    @Query("SELECT * FROM $TABLE_NAME WHERE page = :page")
    suspend fun getByPage(page: Int): List<CharacterEntity>
}