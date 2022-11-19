package com.maandraj.models.ui.catalog

import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.local.catalog.entity.CatalogEntity

data class CatalogData(
    val bestSellerData: List<BestSellerData>,
    val homeStoreData: List<HomeStoreData>,
) : ConvertibleTo<CatalogEntity> {
    override fun convertTo(): CatalogEntity = CatalogEntity(
        bestSeller = bestSellerData.map { it.convertTo() },
        homeStore = homeStoreData.map { it.convertTo() }
    )
}