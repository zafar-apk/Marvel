package com.education.marvel.data.source

import com.education.marvel.data.entity.CharacterNetwork

interface NetworkDataSource {

    suspend fun getCharacters(page: Int): List<CharacterNetwork>

}