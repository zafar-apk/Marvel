package com.education.marvel.di

import com.education.data.di.LocalDataModule
import com.education.data.di.NetworkModule
import com.education.marvel.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module(includes = [NetworkModule::class, LocalDataModule::class, ViewModelModule::class])
object AppModule {

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

}