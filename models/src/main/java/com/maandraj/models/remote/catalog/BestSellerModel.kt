package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.BestSellerData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class BestSellerModel(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String,
) : ConvertibleTo<BestSellerData> {
    override fun convertTo(): BestSellerData = BestSellerData(
        discountPrice = discount_price,
        isFavorites = is_favorites,
        picture = picture,
        priceWithoutDiscount = price_without_discount,
        title = title
    )
}