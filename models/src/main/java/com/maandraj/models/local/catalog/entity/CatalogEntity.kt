package com.maandraj.models.local.catalog.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.CatalogData

@Entity
data class CatalogEntity(
    @PrimaryKey
    val id: Int = 0,
    val bestSeller: List<BestSellerEntity>,
    val homeStore: List<HomeStoreEntity>,
) : ConvertibleTo<CatalogData> {
    override fun convertTo(): CatalogData = CatalogData(
        bestSellerData = bestSeller.map { it.convertTo() },
        homeStoreData = homeStore.map { it.convertTo() }
    )
}