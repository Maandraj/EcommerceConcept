package com.maandraj.core.utils

import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.maandraj.core.R
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.core.presentation.IBaseFragment

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun IBaseFragment<*>.initToolbarTitle(
    toolbarView: Toolbar,
    titleMarginEnd: Int = 0,
    titleMarginStart: Int = 0,
) {
    toolbarView.findViewById<TextView>(R.id.toolbarTitleTextView)?.let { toolbarTitleTextView ->
        toolbarTitleResId?.let {
            toolbarTitleTextView.setText(it)
        } ?: toolbarTitleTextView.setText(toolbarTitle)
        when (gravityToolbarTitle) {
            Gravity.CENTER -> {
                toolbarTitleTextView.gravity = Gravity.CENTER
                if (titleMarginEnd > 0) {
                    (toolbarTitleTextView.layoutParams as? LinearLayout.LayoutParams)?.apply {
                        marginEnd = titleMarginEnd
                    }
                }
                if (titleMarginStart > 0) {
                    (toolbarTitleTextView.layoutParams as? LinearLayout.LayoutParams)?.apply {
                        marginStart = titleMarginStart
                    }
                }
            }
            Gravity.END -> {
                toolbarTitleTextView.gravity = Gravity.END
            }
            else -> {
                toolbarTitleTextView.gravity = Gravity.START
            }
        }
    }
}

fun Fragment.toast(
    message: Any,
    duration: Int = Toast.LENGTH_SHORT,
) = context?.toast(message, duration)

fun Fragment.dimen(@DimenRes resource: Int): Float = requireActivity().dimen(resource)
fun Fragment.dimenPixel(@DimenRes resource: Int): Int = requireActivity().dimenPixel(resource)


