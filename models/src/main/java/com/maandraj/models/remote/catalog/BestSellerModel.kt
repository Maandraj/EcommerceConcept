package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.local.catalog.entity.BestSellerEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BestSellerModel(
    @Json(name = "discount_price")
    val discountPrice: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "is_favorites")
    val isFavorites: Boolean,
    @Json(name = "picture")
    val picture: String,
    @Json(name = "price_without_discount")
    val priceWithoutDiscount: Int,
    @Json(name = "title")
    val title: String,
) : ConvertibleTo<BestSellerEntity> {
    override fun convertTo(): BestSellerEntity = BestSellerEntity(
        id = id,
        discountPrice = discountPrice,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )
}