package com.education.data.utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class StringProvider @Inject constructor(private val appContext: Context) {
    fun getString(@StringRes id: Int) = appContext.getString(id)
}