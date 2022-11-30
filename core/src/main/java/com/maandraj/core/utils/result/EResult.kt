package com.maandraj.core.utils.result

sealed class EResult<out T> {
    data class Success<out R>(val data: R) : EResult<R>()
    data class Failure(
        val message: String? = null,
        val exception: Throwable? = null,
    ) : EResult<Nothing>()

    object Empty : EResult<Nothing>()
}







