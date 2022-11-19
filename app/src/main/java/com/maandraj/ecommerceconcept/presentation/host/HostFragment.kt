package com.maandraj.ecommerceconcept.presentation.host

import android.os.Bundle
import android.view.View
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.maandraj.core.presentation.BaseBindingFragment
import com.maandraj.core.utils.dimen
import com.maandraj.core.utils.dimenPixel
import com.maandraj.ecommerceconcept.R
import com.maandraj.ecommerceconcept.databinding.FragmentHostBinding

class HostFragment : BaseBindingFragment<FragmentHostBinding, HostViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_host

    override fun initBinding(binding: FragmentHostBinding) {
        super.initBinding(binding)
        binding.bottomNavigationView.apply {
            val radius = dimen(R.dimen.corner_radius__tabs_nav_view)
            val bottomNavigationViewBackground = background as MaterialShapeDrawable
            bottomNavigationViewBackground.shapeAppearanceModel =
                bottomNavigationViewBackground.shapeAppearanceModel.toBuilder()
                    .setTopRightCorner(CornerFamily.ROUNDED, radius)
                    .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                    .build()
            itemIconTintList = null
        }
    }
}