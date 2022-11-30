package com.maandraj.data.catalog.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.maandraj.data.catalog.local.database.dao.catalog.CatalogDao
import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.models.local.catalog.entity.conveters.CatalogConverter

// TODO На случай кеширования или добавления в избранное (Пока не работает)
@TypeConverters(CatalogConverter::class)
@Database(
    entities = [CatalogEntity::class],
    version = 1
)
abstract class EccomerceDataBase : RoomDatabase() {
    abstract fun getCatalogDao(): CatalogDao
}