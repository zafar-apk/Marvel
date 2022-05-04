package com.education.data.repository

import com.education.domain.entity.Character
import com.education.domain.repository.CharacterListRepository
import com.education.domain.source.LocalDataSource
import com.education.domain.source.NetworkDataSource
import javax.inject.Inject


class CharacterListRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : CharacterListRepository {

    override suspend fun getFromNetwork(page: Int) = networkDataSource.getCharacters(page)

    override suspend fun getFromDatabase(page: Int) = localDataSource.getByPage(page)

    override suspend fun save(
        characters: List<Character>,
        page: Int
    ) = localDataSource.save(characters, page)

}
