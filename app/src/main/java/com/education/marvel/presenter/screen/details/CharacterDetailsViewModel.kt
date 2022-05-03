package com.education.marvel.presenter.screen.details

import androidx.lifecycle.*
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
) : ViewModel() {

    private val characterMutable = MutableLiveData<Character>()
    val characterLiveData: LiveData<Character> = characterMutable

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            characterMutable.value = getCharacterUseCase(id)
        }
    }

    class Factory @Inject constructor(
        private val getCharacterUseCase: Provider<GetCharacterUseCase>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == CharacterDetailsViewModel::class.java)
            return CharacterDetailsViewModel(
                getCharacterUseCase.get()
            ) as T
        }
    }

}