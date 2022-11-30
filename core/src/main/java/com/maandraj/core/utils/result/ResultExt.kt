package com.maandraj.core.utils.result

import com.maandraj.core.data.base.convertible.Convertible
import com.maandraj.core.data.base.convertible.convert


typealias SInHandler<T> = suspend (T) -> Unit
typealias InHandler<T> = (T) -> Unit

fun emptyResult() = EResult.Empty

inline fun <reified T : Any> successResult(data: T): EResult<T> = EResult.Success(data)

fun Any.errorResult(
    message: String = "",
    exception: Throwable? = null
) = EResult.Failure(message, exception)

inline fun <reified T : Any> T?.toSuccessResult(): EResult<T> =
    this?.let {
        successResult(it)
    } ?: emptyResult()

@Suppress("REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE")
suspend inline fun <reified I : Any> EResult<I>.applyIfSuccessSuspend(crossinline block: SInHandler<I>): EResult<I> {
    if (this is EResult.Success) block(this.data)
    return this
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any, reified I : Convertible> EResult<I>.convertTo(): EResult<T> {
    return when (this) {
        is EResult.Success -> {
            this.data.convert<T>()?.toSuccessResult() ?: emptyResult()
        }
        else -> this as EResult<T>
    }
}

inline fun <reified I : Any> EResult<I>.applyIfSuccess(block: InHandler<I>): EResult<I> {
    if (this is EResult.Success) block(this.data)
    return this
}

inline fun <reified I : Any> EResult<I>.applyIfError(block: InHandler<EResult.Failure>): EResult<I> {
    if (this is EResult.Failure) block(this)
    return this
}