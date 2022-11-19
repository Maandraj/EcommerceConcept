package com.maandraj.core.data.base.convertible

import kotlin.reflect.KClass

interface ConvertibleTo<out T> : Convertible {
    fun convertTo(): T?

    @Suppress("UNCHECKED_CAST")
    override fun <I : Any> convertAs(clazz: KClass<I>): I? = convertTo() as? I
}
inline fun <reified To : Any> Convertible.convert(): To? {
    return convertAs(To::class)
}

