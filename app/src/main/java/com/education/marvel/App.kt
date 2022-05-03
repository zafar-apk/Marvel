package com.education.marvel

import android.app.Application
import com.education.marvel.di.AppComponent
import com.education.marvel.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .newAppComponent(this)
    }

}