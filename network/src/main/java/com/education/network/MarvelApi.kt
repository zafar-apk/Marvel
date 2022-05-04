package com.education.network

import com.education.network.entity.character.CharactersDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    companion object {
        private const val MODIFIED_DESC = "-modified"
        const val BASE_URL = "https://gateway.marvel.com"
    }

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("orderBy") orderBy: String = MODIFIED_DESC
    ): CharactersDataWrapper

}