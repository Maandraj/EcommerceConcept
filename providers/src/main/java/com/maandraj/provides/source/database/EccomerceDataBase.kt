package com.maandraj.provides.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maandraj.models.ui.catalog.HomeStoreData
import com.maandraj.models.local.catalog.entity.BestSellerEntity
import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.models.local.catalog.entity.HomeStoreEntity
import com.maandraj.models.local.catalog.entity.conveters.BestSellerConverter
import com.maandraj.models.local.catalog.entity.conveters.CatalogConverter
import com.maandraj.provides.source.database.dao.catalog.CatalogDao

@TypeConverters(
    CatalogConverter::class,
    BestSellerConverter::class,
    HomeStoreData::class)

@Database(
    entities = [CatalogEntity::class,
        BestSellerEntity::class,
        HomeStoreEntity::class],
    version = 1
)

abstract class EccomerceDataBase : RoomDatabase() {
    abstract fun getCatalogDao(): CatalogDao
}