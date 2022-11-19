package com.maandraj.core.presentation

import androidx.viewbinding.ViewBinding

abstract class BaseBindingFragment<B : ViewBinding, VM : IBaseViewModel> : BaseFragment<VM>(),
    IBaseBindingFragment<B, VM> {

    override val binding: B? = null

    override fun initBinding(binding: B) = Unit

}