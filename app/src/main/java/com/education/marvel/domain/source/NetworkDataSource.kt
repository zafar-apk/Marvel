package com.education.marvel.domain.source

import com.education.marvel.data.entity.Character
import com.education.marvel.data.entity.DataContainer
import com.education.marvel.data.entity.DataWrapper
import com.education.marvel.data.entity.comic.Comic

interface NetworkDataSource {

    suspend fun getComics(): DataWrapper<DataContainer<Comic>>

    suspend fun getComicCharacters(id: Int): DataWrapper<DataContainer<Character>>

    suspend fun getCharacter(id: Int): DataWrapper<DataContainer<Character>>

}