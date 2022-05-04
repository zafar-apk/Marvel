package com.education.marvel.data.source

import com.education.marvel.AppConstants
import com.education.marvel.data.mapper.toCharacter
import com.education.marvel.data.network.MarvelApi
import com.education.marvel.data.utils.CharacterDetailsBuilder
import com.education.marvel.domain.entity.Character
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: MarvelApi,
    private val detailsBuilder: CharacterDetailsBuilder
) : NetworkDataSource {

    override suspend fun getCharacters(page: Int): List<Character> {
        val offset = calculateOffsetByPage(page)
        val data = api.getCharacters(offset).data
        val networkCharacters = data?.results
        return networkCharacters?.map { it.toCharacter(detailsBuilder, page) }.orEmpty()
    }

    private fun calculateOffsetByPage(
        page: Int
    ) = if (page == 1) 0 else AppConstants.DEFAULT_PAGE_SIZE * (page - 1)
}