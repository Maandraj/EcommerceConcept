package com.maandraj.models.local.catalog.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.BestSellerData

@Entity
data class BestSellerEntity(
    @PrimaryKey
    val id: Int = 0,
    val discountPrice: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String,
) : ConvertibleTo<BestSellerData> {
    override fun convertTo(): BestSellerData = BestSellerData(
        discountPrice = discountPrice,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )
}