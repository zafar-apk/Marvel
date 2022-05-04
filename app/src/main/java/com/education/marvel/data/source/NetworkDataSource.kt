package com.education.marvel.data.source

import com.education.marvel.domain.entity.Character

interface NetworkDataSource {

    suspend fun getCharacters(page: Int): List<Character>

}