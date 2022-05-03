package com.education.marvel.di

import android.content.Context
import com.education.marvel.presenter.screen.details.CharacterDetailsFragment
import com.education.marvel.presenter.screen.list.CharacterListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(fragment: CharacterListFragment)
    fun inject(fragment: CharacterDetailsFragment)

    @Component.Factory
    interface Factory {
        fun newAppComponent(@BindsInstance appContext: Context): AppComponent
    }
}