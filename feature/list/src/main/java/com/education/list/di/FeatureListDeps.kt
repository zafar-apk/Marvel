package com.education.list.di

import com.education.domain.usecase.CharacterFormatDateUseCase
import com.education.domain.repository.CharacterListRepository
import kotlinx.coroutines.CoroutineDispatcher

interface FeatureListDeps {

    val repository: CharacterListRepository

    val formatDateUseCase: CharacterFormatDateUseCase

    val dispatcher: CoroutineDispatcher

}