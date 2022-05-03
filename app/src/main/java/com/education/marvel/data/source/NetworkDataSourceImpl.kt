package com.education.marvel.data.source

import com.education.marvel.AppConstants
import com.education.marvel.data.entity.CharacterNetwork
import com.education.marvel.data.network.MarvelApi
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: MarvelApi
) : NetworkDataSource {

    override suspend fun getCharacters(page: Int): List<CharacterNetwork> {
        val offset = calculateOffsetByPage(page)
        val data = api.getCharacters(offset).data
        return data?.results.orEmpty()
    }

    private fun calculateOffsetByPage(
        page: Int
    ) = if (page == 1) 0 else AppConstants.DEFAULT_PAGE_SIZE * (page - 1)
}