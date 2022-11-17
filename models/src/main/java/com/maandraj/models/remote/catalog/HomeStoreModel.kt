package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.local.catalog.entity.HomeStoreEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeStoreModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "is_buy")
    val isBuy: Boolean,
    @Json(name = "is_new")
    val isNew: Boolean?,
    @Json(name = "picture")
    val picture: String,
    @Json(name = "subtitle")
    val subtitle: String,
    @Json(name = "title")
    val title: String,
) : ConvertibleTo<HomeStoreEntity> {
    override fun convertTo(): HomeStoreEntity = HomeStoreEntity(
        id = id,
        isBuy = isBuy,
        isNew = isNew != null,
        picture = picture,
        subtitle = subtitle,
        title = title
    )
}