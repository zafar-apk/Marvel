package com.education.details.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.education.domain.entity.Character
import com.education.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

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

}