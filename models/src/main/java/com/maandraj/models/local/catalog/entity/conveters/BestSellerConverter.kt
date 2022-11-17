package com.maandraj.models.local.catalog.entity.conveters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maandraj.models.ui.catalog.BestSellerData
import com.maandraj.models.ui.catalog.HomeStoreData

class BestSellerConverter {

    @TypeConverter
    fun fromUserData(bestSellerData: BestSellerData): String {
        val type = object : TypeToken<BestSellerData>() {}.type
        return Gson().toJson(bestSellerData, type)
    }

    @TypeConverter
    fun toUserData(data: String?): HomeStoreData {
        val gson = Gson()
        val type = object : TypeToken<HomeStoreData>() {}.type
        return gson.fromJson(data, type)
    }
}