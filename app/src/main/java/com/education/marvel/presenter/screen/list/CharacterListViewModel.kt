package com.education.marvel.presenter.screen.list

import androidx.lifecycle.*
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.entity.Result
import com.education.marvel.domain.usecase.GetCharactersByPageUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class CharacterListViewModel(
    private val getCharactersByPageUseCase: GetCharactersByPageUseCase
) : ViewModel() {

    private companion object {
        const val INITIAL_PAGE = 1
    }

    private var loadedList = listOf<Character>()

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
        loadedList = loadedList + response.items
        mutableCharacters.value = loadedList
    }

    fun retry() {
        getCharacters(loadedList.lastOrNull()?.page ?: INITIAL_PAGE)
    }

    class Factory @Inject constructor(
        private val getCharactersByPageUseCase: Provider<GetCharactersByPageUseCase>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == CharacterListViewModel::class.java)
            return CharacterListViewModel(getCharactersByPageUseCase.get()) as T
        }
    }
}