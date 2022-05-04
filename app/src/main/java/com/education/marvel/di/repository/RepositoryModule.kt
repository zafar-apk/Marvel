package com.education.marvel.di.repository

import com.education.data.repository.CharacterRepositoryImpl
import com.education.data.source.LocalDataSource
import com.education.data.source.LocalDataSourceImpl
import com.education.data.source.NetworkDataSource
import com.education.data.source.NetworkDataSourceImpl
import com.education.domain.repository.CharacterRepository
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