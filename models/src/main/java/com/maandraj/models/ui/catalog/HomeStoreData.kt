package com.maandraj.models.ui.catalog

import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.local.catalog.entity.HomeStoreEntity

data class HomeStoreData(
    val isBuy: Boolean,
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String,
) : ConvertibleTo<HomeStoreEntity> {
    override fun convertTo(): HomeStoreEntity = HomeStoreEntity(
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )
}