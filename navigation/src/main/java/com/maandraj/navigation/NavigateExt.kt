package com.maandraj.navigation

import android.app.Activity
import androidx.fragment.app.Fragment

fun Activity.navigateToFlow(flow: NavigationFlow) =
    (this as? ToFlowNavigatable)?.navigateToFlow(flow)

fun Fragment.navigateToFlow(flow: NavigationFlow) = requireActivity().navigateToFlow(flow)

