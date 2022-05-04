package com.education.marvel.di

import com.education.data.di.LocalDataModule
import com.education.data.di.RepositoryModule
import com.education.marvel.BuildConfig
import com.education.marvel.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module(includes = [LocalDataModule::class, ViewModelModule::class, RepositoryModule::class])
object AppModule {

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideIsDebug(): Boolean = BuildConfig.DEBUG

}