package com.education.data.db

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long?) = dateLong?.let(::Date)

    @TypeConverter
    fun fromDate(date: Date?) = date?.time

}