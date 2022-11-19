package com.maandraj.main

import android.view.Gravity
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maandraj.core.presentation.BaseBindingFragment
import com.maandraj.main.databinding.FragmentMainBinding

class MainFragment : BaseBindingFragment<FragmentMainBinding, MainViewModel>() {

    override val binding: FragmentMainBinding? by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel? by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun initBinding(binding: FragmentMainBinding) {
        with(binding) {

        }
    }
}