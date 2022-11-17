package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatalogModel(
    @Json(name = "best_seller")
    val bestSellerModel: List<BestSellerModel>,
    @Json(name = "home_store")
    val homeStoreModel: List<HomeStoreModel>,
) : ConvertibleTo<CatalogEntity> {
    override fun convertTo(): CatalogEntity = CatalogEntity(
        bestSeller = bestSellerModel.map { it.convertTo() },
        homeStore = homeStoreModel.map { it.convertTo() }
    )
}