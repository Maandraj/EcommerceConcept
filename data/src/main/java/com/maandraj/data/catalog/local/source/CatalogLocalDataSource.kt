package com.maandraj.data.catalog.local.source

import com.maandraj.core.data.base.source.LocalDataSource
import com.maandraj.models.local.catalog.entity.CatalogEntity

interface CatalogLocalDataSource : LocalDataSource {

    suspend fun getCatalog(): CatalogEntity

    suspend fun saveCatalog(catalog : CatalogEntity)

    suspend fun removeCatalog(catalog : CatalogEntity)

}