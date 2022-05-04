package com.education.details.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates.notNull

interface FeatureDetailsDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: FeatureDetailsDeps

    companion object : FeatureDetailsDepsProvider by FeatureDetailsDepsStore
}

object FeatureDetailsDepsStore : FeatureDetailsDepsProvider {
    override var deps: FeatureDetailsDeps by notNull()
}

internal class FeatureDetailsComponentProvider : ViewModel() {
    val featureComponent = DaggerFeatureDetailsComponent.builder()
        .deps(FeatureDetailsDepsStore.deps)
        .build()
}
