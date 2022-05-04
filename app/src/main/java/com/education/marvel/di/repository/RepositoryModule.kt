package com.education.marvel.di.repository

import com.education.marvel.data.repository.CharacterRepositoryImpl
import com.education.marvel.data.source.LocalDataSource
import com.education.marvel.data.source.LocalDataSourceImpl
import com.education.marvel.data.source.NetworkDataSource
import com.education.marvel.data.source.NetworkDataSourceImpl
import com.education.marvel.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindNetworkDataSource(dataSourceImpl: NetworkDataSourceImpl): NetworkDataSource

    @Binds
    fun bindCharacterRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository

}