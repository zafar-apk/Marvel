package com.education.marvel.data.network

import com.education.marvel.data.entity.Character
import com.education.marvel.data.entity.DataContainer
import com.education.marvel.data.entity.DataWrapper
import com.education.marvel.data.entity.comic.Comic
import com.education.marvel.domain.source.NetworkDataSource
import retrofit2.http.GET

interface MarvelApi{

    @GET("/v1/public/characters")
    suspend fun getCharacters(): DataWrapper<DataContainer<Character>>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(id: Int): DataWrapper<DataContainer<Character>>

}