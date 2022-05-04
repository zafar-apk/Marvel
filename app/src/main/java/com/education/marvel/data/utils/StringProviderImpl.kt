package com.education.marvel.data.utils

import android.content.Context
import androidx.annotation.StringRes
import com.education.marvel.domain.provier.StringProvider
import javax.inject.Inject

class StringProviderImpl @Inject constructor(private val appContext: Context) : StringProvider {
    override fun getString(@StringRes id: Int) = appContext.getString(id)
}