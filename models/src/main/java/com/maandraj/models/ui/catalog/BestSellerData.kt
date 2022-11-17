package com.maandraj.models.ui.catalog

data class BestSellerData(
    val discountPrice: Int,
    val isFavorites: Boolean,
    val picture: String,
    val priceWithoutDiscount: Int,
    val title: String
)