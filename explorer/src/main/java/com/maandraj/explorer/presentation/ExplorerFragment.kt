package com.maandraj.explorer.presentation

import android.content.Context
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.maandraj.core.presentation.BaseFragment
import com.maandraj.core.utils.extension.toast
import com.maandraj.explorer.R
import com.maandraj.explorer.databinding.FragmentExplorerBinding
import com.maandraj.explorer.presentation.adapter.category.CategoryData
import com.maandraj.explorer.presentation.adapter.category.categoryAdapterDelegate
import com.maandraj.explorer.presentation.adapter.store.homeStoreAdapterDelegate
import dagger.Lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ExplorerFragment : BaseFragment<ExplorerViewModel>() {

    @Inject
    lateinit var factory: Lazy<ExplorerViewModel.Factory>

    override val viewModel: ExplorerViewModel by viewModels {
        factory.get()
    }
    override val layoutId: Int = R.layout.fragment_explorer
    override val contentViewLayout: View?
        get() = super.contentViewLayout

    private val binding: FragmentExplorerBinding by viewBinding(FragmentExplorerBinding::bind)
    private var rvPosition = -1
        set(value) {
            field = if ((adapterHome.items?.size ?: 0) <= value) -1
            else value
        }
    private val adapterCategory = ListDelegationAdapter(
        categoryAdapterDelegate { item, positionScroll ->
            toast(getString(item.nameResId))
            (binding.rvCategories.layoutManager as? LinearLayoutManager)?.scrollToPositionWithOffset(
                positionScroll, SCROLL_OFFSET)
        }
    )
    private val adapterHome = ListDelegationAdapter(
        homeStoreAdapterDelegate { item ->
            toast(item.title)
        }
    )

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<ExplorerComponentViewModel>().explorerComponent.inject(this)
        super.onAttach(context)
    }

    override fun initBinding() {
        viewModel.getCatalog()
        with(binding) {
            rvCategories.adapter = adapterCategory
            LinearSnapHelper().attachToRecyclerView(rvHomeStore)
            rvHomeStore.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val offset: Int = rvHomeStore.computeHorizontalScrollOffset()
                    var position: Float =
                        offset.toFloat() / (rvHomeStore.getChildAt(0).measuredWidth).toFloat()
                    position += 0.5f
                    val postInt: Int = position.toInt()
                    val positionIndex = postInt + 1
                    val listSize = adapterHome.items?.size ?: 0
                    rvPosition = positionIndex / listSize
                }
            })
        }
        adapterCategory.items = CategoryData.createListExample()

        setAutoScrollHomeStore()
        setObservable()
    }

    private fun setObservable() {
        viewModel.catalog.observe(viewLifecycleOwner) {
            adapterHome.items = it.homeStoreData
            binding.rvHomeStore.adapter = adapterHome
        }
    }

    private fun setAutoScrollHomeStore() {
        lifecycleScope.launch(Dispatchers.IO) {
            while (true) {
                delay(AUTO_SCROLL_MILLS)
                withContext(Dispatchers.Main) {
                    (binding.rvHomeStore.smoothScrollToPosition(rvPosition + 1))
                    rvPosition++
                }
            }
        }
    }
}

private const val SCROLL_OFFSET = 20
private const val AUTO_SCROLL_MILLS = 5000L