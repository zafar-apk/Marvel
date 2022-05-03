package com.education.marvel.domain.entity

sealed class Result<out T : Any> {
    object Loading : Result<Nothing>()
    data class Page<T : Any>(val items: List<T>) : Result<T>() {
        val isEndOfPagination: Boolean
            get() = items.isEmpty()
    }
    data class Error(val throwable: Throwable) : Result<Nothing>()
}