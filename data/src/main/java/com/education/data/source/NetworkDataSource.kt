package com.education.data.source

import com.education.domain.entity.Character

interface NetworkDataSource {

    suspend fun getCharacters(page: Int): List<Character>

}