package com.maandraj.models.local.catalog.entity.conveters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maandraj.models.ui.catalog.CatalogData

class CatalogConverter {

    @TypeConverter
    fun fromUserData(catalog: CatalogData): String {
        val type = object : TypeToken<CatalogData>() {}.type
        return Gson().toJson(catalog, type)
    }

    @TypeConverter
    fun toUserData(data: String?): CatalogData {
        val gson = Gson()
        val type = object : TypeToken<CatalogData>() {}.type
        return gson.fromJson(data, type)
    }
}