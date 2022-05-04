package com.education.list.di

import com.education.list.presentation.CharacterListFragment
import dagger.Component

@Component(dependencies = [FeatureListDeps::class])
interface FeatureListComponent {

    fun inject(fragment: CharacterListFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: FeatureListDeps): Builder

        fun build(): FeatureListComponent

    }

}