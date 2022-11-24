package com.maandraj.explorer.presentation.adapter.sales

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maandraj.core.utils.adapter.DisplayableItem
import com.maandraj.explorer.databinding.ItemHotSalesBinding
import com.maandraj.models.ui.catalog.BestSellerData


fun sellersAdapterDelegate(
    itemClickedListener: (BestSellerData) -> Unit,
) = adapterDelegateViewBinding<BestSellerData,
        DisplayableItem, ItemHotSalesBinding>(
    { layoutInflater, root ->
        ItemHotSalesBinding.inflate(layoutInflater, root, false)

    }
) {
    binding.btnBuySale.setOnClickListener {
        itemClickedListener(item)
    }
    bind {

    }
}
