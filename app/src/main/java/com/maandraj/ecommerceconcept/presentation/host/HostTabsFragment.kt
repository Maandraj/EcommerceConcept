package com.maandraj.ecommerceconcept.presentation.host

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.core.utils.extension.dimen
import com.maandraj.ecommerceconcept.R
import com.maandraj.ecommerceconcept.databinding.FragmentHostTabsBinding

class HostTabsFragment : BaseFragment<HostTabsViewModel>() {

    private val binding: FragmentHostTabsBinding by viewBinding(FragmentHostTabsBinding::bind)
    override val viewModel: HostTabsViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_host_tabs

    override fun initBinding() {
        binding.bottomNavigationView.apply {
            val radius = dimen(R.dimen.corner_radius__tabs_nav_view)
            val bottomNavigationViewBackground = background as MaterialShapeDrawable
            bottomNavigationViewBackground.shapeAppearanceModel =
                bottomNavigationViewBackground.shapeAppearanceModel.toBuilder()
                    .setTopRightCorner(CornerFamily.ROUNDED, radius)
                    .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                    .setBottomRightCorner(CornerFamily.ROUNDED, radius)
                    .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                    .build()
            itemIconTintList = null
        }
    }
}