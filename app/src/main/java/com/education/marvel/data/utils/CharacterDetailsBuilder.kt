package com.education.marvel.data.utils

import com.education.marvel.R
import com.education.marvel.data.entity.SummaryList
import com.education.marvel.data.entity.character.CharacterNetwork
import com.education.marvel.domain.provier.StringProvider
import javax.inject.Inject


class CharacterDetailsBuilder @Inject constructor(
    private val stringProvider: StringProvider
) {

    fun build(character: CharacterNetwork) = mutableListOf<String>().apply {
        addNotNull(character.comics, stringProvider.getString(R.string.comics_label))
        addNotNull(character.stories, stringProvider.getString(R.string.stories_label))
        addNotNull(character.events, stringProvider.getString(R.string.events_label))
        addNotNull(character.series, stringProvider.getString(R.string.series_label))
    }

    private fun MutableList<String>.addNotNull(data: SummaryList?, label: String) {
        val details = data?.items?.mapNotNull { it?.name }
        if (!details.isNullOrEmpty()) {
            add(label)
            addAll(details.filter(String::isNotEmpty))
            add("\n")
        }
    }
}