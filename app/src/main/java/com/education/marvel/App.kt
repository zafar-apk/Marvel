package com.education.marvel

import android.app.Application
import com.education.details.di.FeatureDetailsDepsStore
import com.education.list.di.FeatureListDepsStore
import com.education.marvel.di.AppComponent
import com.education.marvel.di.DaggerAppComponent

class App : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .newAppComponent(this)
    }

    override fun onCreate() {
        super.onCreate()
        FeatureListDepsStore.deps = appComponent
        FeatureDetailsDepsStore.deps = appComponent
    }

}