package com.maandraj.explorer.presentation

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.core.utils.toast
import com.maandraj.explorer.R
import com.maandraj.explorer.databinding.FragmentExplorerBinding
import com.maandraj.explorer.presentation.adapter.CategoryData
import com.maandraj.explorer.presentation.adapter.categoryAdapterDelegate


class ExplorerFragment : BaseFragment<ExplorerViewModel>() {

    override val viewModel: ExplorerViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_explorer

    private val binding: FragmentExplorerBinding by viewBinding(FragmentExplorerBinding::bind)
    private var adapter = ListDelegationAdapter(
        categoryAdapterDelegate() { item, positionScroll ->
            toast(item.toString())
            (binding.rvCategories.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(
                positionScroll, SCROLL_OFFSET)

        }
    )

    override fun initBinding() {
        with(binding) {
            rvCategories.adapter = adapter
        }
        adapter.items = CategoryData.createListExample()
        setSearchBox()
    }

    private fun setSearchBox() {
        with(binding) {
            tilSearch.setStartIconTintList(ContextCompat.getColorStateList(requireContext(),
                com.maandraj.core.R.color.color_main))
        }

    }
}

private const val SCROLL_OFFSET = 20