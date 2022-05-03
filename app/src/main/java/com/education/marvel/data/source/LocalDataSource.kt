package com.education.marvel.data.source

import com.education.marvel.data.entity.CharacterEntity

interface LocalDataSource {

    suspend fun save(vararg characterEntity: CharacterEntity)

    suspend fun getByPage(page: Int): List<CharacterEntity>

    suspend fun getById(id: Int): CharacterEntity

    suspend fun clear()

}