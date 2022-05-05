package com.education.marvel

import android.app.Application
import com.education.details.di.FeatureDetailsDeps
import com.education.details.di.FeatureDetailsDepsProvider
import com.education.list.di.FeatureListDeps
import com.education.list.di.FeatureListDepsProvider
import com.education.marvel.di.AppComponent
import com.education.marvel.di.DaggerAppComponent

class App : Application(), FeatureDetailsDepsProvider, FeatureListDepsProvider {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .newAppComponent(this)
    }

    override val featureDetailsDeps: FeatureDetailsDeps by lazy { appComponent }

    override val featureListDeps: FeatureListDeps by lazy { appComponent }

}