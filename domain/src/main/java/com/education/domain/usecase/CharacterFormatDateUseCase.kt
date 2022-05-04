package com.education.domain.usecase

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CharacterFormatDateUseCase @Inject constructor() {

    private companion object {
        private const val DATE_FORMAT = "yyyy.MM.dd"
    }

    fun format(date: Date?) = date?.let {
        SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
    }.orEmpty()

}