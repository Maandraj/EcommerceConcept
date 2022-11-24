package com.maandraj.models.ui.catalog

import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.core.utils.adapter.DisplayableItem
import com.maandraj.models.local.catalog.entity.BestSellerEntity

data class BestSellerData(
    val discountPrice: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
): ConvertibleTo<BestSellerEntity>, DisplayableItem {
    override fun convertTo(): BestSellerEntity = BestSellerEntity(
        discountPrice = discountPrice,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )
}