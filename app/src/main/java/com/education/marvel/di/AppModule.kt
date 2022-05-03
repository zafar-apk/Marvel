package com.education.marvel.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module(includes = [NetworkModule::class, LocalDataModule::class, ProvidersModule::class])
object AppModule {

    @Provides
    fun provideDispatcher() = Dispatchers.IO

}