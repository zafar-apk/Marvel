package com.education.data.di

import com.education.data.source.LocalDataSourceImpl
import com.education.data.source.NetworkDataSourceImpl
import com.education.domain.source.LocalDataSource
import com.education.domain.source.NetworkDataSource
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
interface DataSourceModule {

    @Binds
    fun bindLocalDataSource(dataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindNetworkDataSource(dataSourceImpl: NetworkDataSourceImpl): NetworkDataSource

}