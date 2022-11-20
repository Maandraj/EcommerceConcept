package com.maandraj.explorer

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.explorer.databinding.FragmentExplorerBinding


class ExplorerFragment : BaseFragment<ExplorerViewModel>() {

    private val binding: FragmentExplorerBinding by viewBinding(FragmentExplorerBinding::bind)
    override val viewModel: ExplorerViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_explorer


    override fun initBinding() {
        with(binding) {

        }
    }
}