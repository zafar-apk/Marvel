package com.education.marvel.di

import com.education.marvel.data.utils.StringProviderImpl
import com.education.marvel.domain.provier.StringProvider
import dagger.Binds
import dagger.Module

@Module
interface ProvidersModule {

    @Binds
    fun bindStringProvider(providerImpl: StringProviderImpl): StringProvider

}