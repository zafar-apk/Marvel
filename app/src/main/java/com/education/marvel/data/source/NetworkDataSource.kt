package com.education.marvel.data.source

import com.education.marvel.data.entity.character.CharacterNetwork

interface NetworkDataSource {

    suspend fun getCharacters(page: Int): List<CharacterNetwork>

}