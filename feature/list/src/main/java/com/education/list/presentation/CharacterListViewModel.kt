package com.education.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.education.domain.entity.Character
import com.education.domain.entity.Result
import com.education.list.domain.usecase.GetCharactersByPageUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getCharactersByPageUseCase: GetCharactersByPageUseCase
) : ViewModel() {

    private companion object {
        const val INITIAL_PAGE = 1
    }

    private val allCharacters = mutableSetOf<Character>()

    private val mutableCharacters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = mutableCharacters

    private val mutableError = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = mutableError

    private val mutableLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = mutableLoading

    init {
        getCharacters(INITIAL_PAGE)
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            getCharactersByPageUseCase(page).collectLatest { response ->
                when (response) {
                    is Result.Error -> mutableError.value = response.throwable
                    is Result.Page -> onPage(response)
                }
                mutableLoading.value = response is Result.Loading
            }
        }
    }

    private fun onPage(response: Result.Page<Character>) {
        allCharacters += response.items
        mutableCharacters.value = allCharacters.toList()
    }

    fun retry() {
        getCharacters(allCharacters.lastOrNull()?.page ?: INITIAL_PAGE)
    }

}