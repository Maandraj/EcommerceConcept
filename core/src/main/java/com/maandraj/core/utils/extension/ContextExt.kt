package com.maandraj.core.utils.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.DimenRes

fun Context.dimen(@DimenRes resource: Int) = resources.getDimension(resource)
fun Context.dimenPixel(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)

fun Context.toast(message: Any, duration: Int = Toast.LENGTH_SHORT) {
    when (message) {
        is String -> {
            if (message.isNotEmpty())
                Toast.makeText(this, message, duration).show()
        }
        is Int -> {
            if (message > 0) Toast.makeText(this, message, duration).show()
        }
        else -> Unit
    }
}