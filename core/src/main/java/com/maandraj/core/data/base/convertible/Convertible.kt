package com.maandraj.core.data.base.convertible

import kotlin.reflect.KClass

interface Convertible {
    fun <I : Any> convertAs(clazz: KClass<I>): I?
}