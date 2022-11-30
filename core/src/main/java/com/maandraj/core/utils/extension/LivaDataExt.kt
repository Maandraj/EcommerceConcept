package com.maandraj.core.utils.extension

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.asLiveData(): LiveData<T> = this
