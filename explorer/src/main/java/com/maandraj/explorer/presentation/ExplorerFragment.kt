package com.maandraj.explorer.presentation

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.core.utils.extension.toast
import com.maandraj.explorer.R
import com.maandraj.explorer.databinding.FragmentExplorerBinding
import com.maandraj.explorer.presentation.adapter.category.CategoryData
import com.maandraj.explorer.presentation.adapter.category.categoryAdapterDelegate
import com.maandraj.explorer.presentation.adapter.sales.sellersAdapterDelegate


class ExplorerFragment : BaseFragment<ExplorerViewModel>() {

    override val viewModel: ExplorerViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_explorer
    override val contentViewLayout: View?
        get() = super.contentViewLayout

    private val binding: FragmentExplorerBinding by viewBinding(FragmentExplorerBinding::bind)

    private var adapter = ListDelegationAdapter(
        categoryAdapterDelegate() { item, positionScroll ->
            toast(item.toString())
            (binding.rvCategories.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(
                positionScroll, SCROLL_OFFSET)
        },
        sellersAdapterDelegate() { item ->
            toast(item.toString())
        },
    )


    override fun initBinding() {
        with(binding) {
            rvCategories.adapter = adapter
            rvHotSeles.adapter = adapter
        }
        adapter.items = CategoryData.createListExample()
        setSearchBox()
    }

    private fun setSearchBox() {
        with(binding) {

        }

    }
}

private const val SCROLL_OFFSET = 20