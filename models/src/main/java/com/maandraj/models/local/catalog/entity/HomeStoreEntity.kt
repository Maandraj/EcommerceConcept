package com.maandraj.models.local.catalog.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.HomeStoreData

@Entity
data class HomeStoreEntity(
    @PrimaryKey
    val id: Int = 0,
    val isBuy: Boolean,
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
) : ConvertibleTo<HomeStoreData> {
    override fun convertTo(): HomeStoreData = HomeStoreData(
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )
}