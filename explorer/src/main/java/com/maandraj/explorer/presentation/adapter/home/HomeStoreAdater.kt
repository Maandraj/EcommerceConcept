package com.maandraj.explorer.presentation.adapter.home

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maandraj.core.utils.adapter.DisplayableItem
import com.maandraj.core.utils.extension.hide
import com.maandraj.core.utils.extension.show
import com.maandraj.explorer.databinding.ItemHomeStoreBinding
import com.maandraj.models.ui.catalog.HomeStoreData


fun homeStoreAdapterDelegate(
    itemClickedListener: (HomeStoreData) -> Unit,

) = adapterDelegateViewBinding<HomeStoreData,
        DisplayableItem, ItemHomeStoreBinding>(
    { layoutInflater, root ->
        ItemHomeStoreBinding.inflate(layoutInflater, root, false)
    }
) {
    with(binding) {
        btnBuySale.setOnClickListener {
            itemClickedListener(item)
        }
        bind {
            tvTitleSale.text = item.title
            tvSubtitleSale.text = item.subtitle
            if (item.isNew) layoutNewSale.show() else layoutNewSale.hide()
            Glide.with(context).load(item.picture).into(ivImageSale)
        }
    }
}
