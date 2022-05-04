package com.education.marvel.domain.usecase

import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.entity.Result
import com.education.marvel.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharactersByPageUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val formatDateUseCase: CharacterFormatDateUseCase,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(page: Int) = withContext(dispatcher) {
        flow {
            emit(Result.Loading)
            val localCharacters = repository.getFromDatabase(page)
            if (!localCharacters.isNullOrEmpty()) {
                val withDateFormatted = localCharacters.formatDate()
                emit(Result.Page(items = withDateFormatted))
            } else {
                emit(getFromNetworkThenSave(page))
            }
        }
    }

    private suspend fun getFromNetworkThenSave(page: Int): Result<Character> = runCatching {
        val characters = repository.getFromNetwork(page)
        val formattedCharacters = characters.formatDate()
        repository.save(formattedCharacters, page)
        Result.Page(items = formattedCharacters)
    }.getOrElse { throwable ->
        Result.Error(throwable)
    }

    private fun List<Character>.formatDate() = map { character ->
        character.copy(modifiedFormatted = formatDateUseCase.format(character.modified))
    }

}