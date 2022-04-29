package com.education.marvel.di

import android.content.Context
import com.education.marvel.presenter.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun newAppComponent(appContext: Context)
    }
}