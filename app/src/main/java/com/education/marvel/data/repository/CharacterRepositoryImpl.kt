package com.education.marvel.data.repository

import com.education.marvel.data.entity.character.CharacterEntity
import com.education.marvel.data.mapper.toCharacter
import com.education.marvel.data.mapper.toEntity
import com.education.marvel.data.source.LocalDataSource
import com.education.marvel.data.source.NetworkDataSource
import com.education.marvel.data.utils.CharacterDetailsBuilder
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource,
    private val detailsBuilder: CharacterDetailsBuilder,
    private val dispatcher: CoroutineDispatcher
) : CharacterRepository {

    override suspend fun getFromNetwork(page: Int) = withContext(dispatcher) {
        networkDataSource.getCharacters(page)
            .map { characterNetwork -> characterNetwork.toCharacter(detailsBuilder, page) }
    }

    override suspend fun getFromDatabase(page: Int) = withContext(dispatcher) {
        localDataSource.getByPage(page)
            .map(CharacterEntity::toCharacter)
    }

    override suspend fun save(
        characters: List<Character>,
        page: Int
    ) = withContext(dispatcher) {
        val mappedCharacters = characters.map { character -> character.toEntity(page) }
        localDataSource.save(*mappedCharacters.toTypedArray())
    }

    override suspend fun getById(id: Int) = withContext(dispatcher) {
        localDataSource.getById(id).toCharacter()
    }

    override suspend fun clear() = localDataSource.clear()

}
