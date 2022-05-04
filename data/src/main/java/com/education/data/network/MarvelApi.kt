package com.education.data.network

import com.education.data.entity.character.CharactersDataWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    private companion object {
        const val MODIFIED_DESC = "-modified"
    }

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("orderBy") orderBy: String = MODIFIED_DESC
    ): CharactersDataWrapper

}