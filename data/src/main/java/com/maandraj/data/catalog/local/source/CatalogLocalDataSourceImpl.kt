package com.maandraj.data.catalog.local.source

import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.data.catalog.local.database.dao.catalog.CatalogDao
import javax.inject.Inject

class CatalogLocalDataSourceImpl (
    private val catalogDao: CatalogDao,
) : CatalogLocalDataSource {

    override suspend fun getCatalog() = catalogDao.getCatalog()

    override suspend fun saveCatalog(catalog: CatalogEntity) = catalogDao.insert(catalog)

    override suspend fun removeCatalog(catalog: CatalogEntity) = catalogDao.delete(catalog)

}