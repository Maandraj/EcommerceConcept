package com.maandraj.provides.source.database.dao.catalog

import androidx.room.Dao
import androidx.room.Query
import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.provides.source.database.dao.base.BaseDao

@Dao
interface CatalogDao : BaseDao<CatalogEntity> {

    @Query("SELECT * FROM CatalogEntity")
    suspend fun getCatalog(): CatalogEntity
}