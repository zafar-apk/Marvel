package com.education.data.repository

import com.education.data.source.LocalDataSource
import com.education.data.source.NetworkDataSource
import com.education.domain.entity.Character
import com.education.domain.repository.CharacterRepository
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource
) : CharacterRepository {

    override suspend fun getFromNetwork(page: Int) = networkDataSource.getCharacters(page)

    override suspend fun getFromDatabase(page: Int) = localDataSource.getByPage(page)

    override suspend fun getById(id: Int) = localDataSource.getById(id)

    override suspend fun save(
        characters: List<Character>,
        page: Int
    ) = localDataSource.save(characters, page)

}
