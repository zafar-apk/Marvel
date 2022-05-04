package com.education.details.di

import com.education.details.presenter.CharacterDetailsFragment
import dagger.Component

@Component(dependencies = [FeatureDetailsDeps::class])
interface FeatureDetailsComponent {

    fun inject(fragment: CharacterDetailsFragment)

    @Component.Builder
    interface Builder {

        fun deps(deps: FeatureDetailsDeps): Builder

        fun build(): FeatureDetailsComponent

    }

}