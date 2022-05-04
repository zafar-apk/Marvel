package com.education.domain.repository

import com.education.domain.entity.Character

interface CharacterListRepository {

    suspend fun getFromNetwork(page: Int): List<Character>

    suspend fun getFromDatabase(page: Int): List<Character>

    suspend fun save(characters: List<Character>, page: Int)

}