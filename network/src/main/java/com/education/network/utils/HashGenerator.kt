package com.education.network.utils

import com.education.network.Keys
import java.math.BigInteger
import java.security.MessageDigest

internal object HashGenerator {

    fun generate(timestamp: Long) = buildString {
        append(timestamp)
        append(Keys.PRIVATE_KEY)
        append(Keys.PUBLIC_KEY)
    }.toMd5()

    private fun String.toMd5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}