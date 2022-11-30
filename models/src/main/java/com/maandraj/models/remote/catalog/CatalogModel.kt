package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.CatalogData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class CatalogModel(
    val best_seller: List<BestSellerModel?>?,
    val home_store: List<HomeStoreModel?>?,
) : ConvertibleTo<CatalogData> {
    override fun convertTo(): CatalogData = CatalogData(
        bestSellerData = best_seller?.mapNotNull { it?.convertTo() } ?: emptyList(),
        homeStoreData = home_store?.mapNotNull { it?.convertTo() } ?: emptyList()
    )
}