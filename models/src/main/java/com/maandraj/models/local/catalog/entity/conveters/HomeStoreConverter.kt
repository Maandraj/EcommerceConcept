package com.maandraj.models.local.catalog.entity.conveters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.maandraj.models.ui.catalog.HomeStoreData

class HomeStoreConverter {

    @TypeConverter
    fun fromUserData(homeStoreData: HomeStoreData): String {
        val type = object : TypeToken<HomeStoreData>() {}.type
        return Gson().toJson(homeStoreData, type)
    }

    @TypeConverter
    fun toUserData(data: String?): HomeStoreData {
        val gson = Gson()
        val type = object : TypeToken<HomeStoreData>() {}.type
        return gson.fromJson(data, type)
    }
}