package com.education.marvel.data.repository

import com.education.marvel.data.entity.character.CharacterEntity
import com.education.marvel.data.mapper.toCharacter
import com.education.marvel.data.mapper.toEntity
import com.education.marvel.data.source.LocalDataSource
import com.education.marvel.data.source.NetworkDataSource
import com.education.marvel.data.utils.CharacterDetailsBuilder
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.repository.CharacterRepository
import javax.inject.Inject


class CharacterRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val networkDataSource: NetworkDataSource,
    private val detailsBuilder: CharacterDetailsBuilder
) : CharacterRepository {

    override suspend fun getFromNetwork(page: Int) = networkDataSource.getCharacters(page)
        .map { characterNetwork -> characterNetwork.toCharacter(detailsBuilder, page) }

    override suspend fun getFromDatabase(page: Int) = localDataSource.getByPage(page)
        .map(CharacterEntity::toCharacter)

    override suspend fun save(
        characters: List<Character>,
        page: Int
    ) {
        val mappedCharacters = characters.map { character -> character.toEntity(page) }
        localDataSource.save(*mappedCharacters.toTypedArray())
    }

    override suspend fun getById(id: Int) = localDataSource.getById(id).toCharacter()

}
