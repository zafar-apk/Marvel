package com.education.marvel.data.source

import com.education.marvel.domain.entity.Character

interface LocalDataSource {

    suspend fun getByPage(page: Int): List<Character>

    suspend fun getById(id: Int): Character

    suspend fun save(characters: List<Character>, page: Int)

}