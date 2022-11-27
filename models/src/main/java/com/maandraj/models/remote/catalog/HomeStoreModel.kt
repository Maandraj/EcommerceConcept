package com.maandraj.models.remote.catalog


import com.maandraj.core.data.base.convertible.ConvertibleTo
import com.maandraj.models.ui.catalog.HomeStoreData
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeStoreModel(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean?,
    val picture: String,
    val subtitle: String,
    val title: String,
) : ConvertibleTo<HomeStoreData> {
    override fun convertTo(): HomeStoreData = HomeStoreData(
        isBuy = is_buy,
        isNew = is_new != null,
        picture = picture,
        subtitle = subtitle,
        title = title
    )
}