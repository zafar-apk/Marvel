package com.education.marvel.data.source

import com.education.marvel.data.db.CharacterDao
import com.education.marvel.data.entity.character.CharacterEntity
import com.education.marvel.data.mapper.toCharacter
import com.education.marvel.data.mapper.toEntity
import com.education.marvel.domain.entity.Character
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val dao: CharacterDao
) : LocalDataSource {

    override suspend fun getByPage(page: Int) = dao.getByPage(page)
        .map(CharacterEntity::toCharacter)

    override suspend fun getById(id: Int) = dao.getById(id).toCharacter()

    override suspend fun save(characters: List<Character>, page: Int) {
        val mappedCharacters = characters.map { character -> character.toEntity(page) }
        return dao.save(*mappedCharacters.toTypedArray())
    }

}