package com.education.marvel.domain.repository

import com.education.marvel.domain.entity.Character

interface CharacterRepository {

    suspend fun getFromNetwork(page: Int): List<Character>

    suspend fun getFromDatabase(page: Int): List<Character>

    suspend fun save(characters: List<Character>, page: Int)

    suspend fun getById(id: Int): Character

}