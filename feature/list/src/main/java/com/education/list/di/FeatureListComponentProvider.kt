package com.education.list.di

import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates.notNull

interface FeatureListDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: FeatureListDeps

    companion object : FeatureListDepsProvider by FeatureListDepsStore
}

object FeatureListDepsStore : FeatureListDepsProvider {
    override var deps: FeatureListDeps by notNull()
}

internal class FeatureListComponentViewModel : ViewModel() {
    val featureComponent = DaggerFeatureListComponent.builder()
        .deps(FeatureListDepsStore.deps)
        .build()
}
