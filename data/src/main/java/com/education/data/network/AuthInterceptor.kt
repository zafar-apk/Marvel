package com.education.data.network

import com.education.data.BuildConfig
import com.education.data.utils.HashGenerator
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    private companion object {
        const val API_KEY = "apikey"
        const val TS = "ts"
        const val HASH = "hash"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val timestamp = Calendar.getInstance().timeInMillis

        val url = chain.request().url.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.public_api_key)
            .addQueryParameter(TS, timestamp.toString())
            .addQueryParameter(HASH, HashGenerator.generate(timestamp))
            .build()

        val request = chain.request().newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}