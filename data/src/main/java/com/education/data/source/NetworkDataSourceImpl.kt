package com.education.data.source

import com.education.data.mapper.toCharacter
import com.education.data.network.MarvelApi
import com.education.data.utils.CharacterDetailsBuilder
import com.education.domain.AppConstants
import com.education.domain.entity.Character
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