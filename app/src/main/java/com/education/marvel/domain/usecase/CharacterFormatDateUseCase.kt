package com.education.marvel.domain.usecase

import android.text.format.DateFormat
import java.util.*
import javax.inject.Inject

class CharacterFormatDateUseCase @Inject constructor() {

    private companion object {
        private const val DATE_FORMAT = "yyyy.MM.dd"
    }

    fun format(date: Date?) = date?.let { DateFormat.format(DATE_FORMAT, date).toString() } ?: ""

}