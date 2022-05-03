package com.education.marvel.data.utils

import com.education.marvel.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest

object HashGenerator {

    fun generate(timestamp: Long) = buildString {
        append(timestamp)
        append(BuildConfig.private_api_key)
        append(BuildConfig.public_api_key)
    }.toMd5()

    private fun String.toMd5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}