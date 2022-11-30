package com.maandraj.core.utils.extension

import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.fragment.app.Fragment
import com.maandraj.core.utils.extension.dimen
import com.maandraj.core.utils.extension.dimenPixel
import com.maandraj.core.utils.extension.hideKeyboard
import com.maandraj.core.utils.extension.toast

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Fragment.toast(
    message: Any,
    duration: Int = Toast.LENGTH_SHORT,
) = context?.toast(message, duration)

fun Fragment.dimen(@DimenRes resource: Int): Float = requireActivity().dimen(resource)
fun Fragment.dimenPixel(@DimenRes resource: Int): Int = requireActivity().dimenPixel(resource)


