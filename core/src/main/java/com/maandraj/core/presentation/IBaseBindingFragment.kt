package com.maandraj.core.presentation

import androidx.viewbinding.ViewBinding

interface IBaseBindingFragment<B : ViewBinding, VM : IBaseViewModel >  : IBaseFragment<VM>{
    val binding: B?
    fun initBinding(binding: B)
}