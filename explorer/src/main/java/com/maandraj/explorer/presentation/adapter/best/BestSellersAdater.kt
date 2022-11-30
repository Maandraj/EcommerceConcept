package com.maandraj.explorer.presentation.adapter.best

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maandraj.core.utils.adapter.DisplayableItem
import com.maandraj.explorer.databinding.ItemBestSellerBinding
import com.maandraj.models.ui.catalog.BestSellerData

//TODO Типа заглушка

fun bestSellersAdapterDelegate(
    itemClickedListener: (BestSellerData) -> Unit,
    itemClickedFavourite: (isFavourite:Boolean, item:BestSellerData) -> Unit,
) = adapterDelegateViewBinding<BestSellerData,
        DisplayableItem, ItemBestSellerBinding>(
    { layoutInflater, root ->
        ItemBestSellerBinding.inflate(layoutInflater, root, false)
    }
) {
    with(binding) {
        root.setOnClickListener {
            itemClickedListener(item)
        }
        btnFavourite.setOnClickListener {
            if (item.isFavorites) {
                ivFavourite.setImageResource(com.maandraj.core.R.drawable.ic_favourite_outline_11dp)
            } else {
                ivFavourite.setImageResource(com.maandraj.core.R.drawable.ic_favourite_filled_11dp)
            }
            item.isFavorites = !item.isFavorites
            itemClickedFavourite(item.isFavorites, item)
        }
        bind {
            tvTitleBestItem.text = item.title
            tvCurrentPrice.text = "$" + item.priceWithoutDiscount
            tvDiscountPrice.text = "$" + item.discountPrice.toString()
            Glide.with(context).load(item.picture).into(ivImage)
            if (item.isFavorites) ivFavourite.setImageResource(com.maandraj.core.R.drawable.ic_favourite_filled_11dp)
            else ivFavourite.setImageResource(com.maandraj.core.R.drawable.ic_favourite_outline_11dp)
        }
    }
}
