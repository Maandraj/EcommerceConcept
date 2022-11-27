package com.maandraj.models.local.catalog.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.CatalogData

@Entity
data class CatalogEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @Ignore @Embedded var bestSellerEntity: List<BestSellerEntity> = listOf(),
    @Ignore @Embedded var homeStoreEntity: List<HomeStoreEntity> = listOf(),
) : ConvertibleTo<CatalogData> {

    override fun convertTo(): CatalogData = CatalogData(
        bestSellerData = bestSellerEntity.map { it.convertTo() },
        homeStoreData = homeStoreEntity.map { it.convertTo() }
    )
}