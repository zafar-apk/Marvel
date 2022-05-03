package com.education.marvel.domain.usecase

import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val formatDateUseCase: CharacterFormatDateUseCase
) {

    suspend operator fun invoke(id: Int): Character {
        val character = repository.getById(id)
        return character.copy(
            modifiedFormatted = formatDateUseCase.format(character.modified)
        )
    }

}