package com.education.marvel.di

import android.content.Context
import androidx.room.Room
import com.education.marvel.data.db.MarvelDatabase
import com.education.marvel.data.source.LocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalDataModule {

    private const val DB_NAME = "marvel_db"

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MarvelDatabase = Room.databaseBuilder(
        context, MarvelDatabase::class.java, DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(database: MarvelDatabase): LocalDataSource = database.dao()

}