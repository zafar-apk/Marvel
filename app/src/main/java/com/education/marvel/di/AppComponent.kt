package com.education.marvel.di

import android.content.Context
import com.education.details.di.FeatureDetailsDeps
import com.education.domain.repository.CharacterListRepository
import com.education.domain.repository.CharacterRepository
import com.education.domain.usecase.CharacterFormatDateUseCase
import com.education.list.di.FeatureListDeps
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : FeatureListDeps, FeatureDetailsDeps {

    override val detailsRepository: CharacterRepository
    override val repository: CharacterListRepository
    override val formatDateUseCase: CharacterFormatDateUseCase
    override val dispatcher: CoroutineDispatcher

    @Component.Factory
    interface Factory {
        fun newAppComponent(@BindsInstance appContext: Context): AppComponent
    }

}