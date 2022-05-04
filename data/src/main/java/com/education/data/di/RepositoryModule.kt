package com.education.data.di

import com.education.data.repository.CharacterListRepositoryImpl
import com.education.data.repository.CharacterRepositoryImpl
import com.education.domain.repository.CharacterListRepository
import com.education.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DataSourceModule::class])
interface RepositoryModule {

    @Binds
    fun bindCharacterListRepository(repositoryImpl: CharacterListRepositoryImpl): CharacterListRepository

    @Binds
    fun bindCharacterRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository

}