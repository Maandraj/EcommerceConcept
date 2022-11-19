package com.maandraj.data.catalog.source.local.catalog

import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.provides.source.database.dao.catalog.CatalogDao
import javax.inject.Inject

class CatalogLocalDataSourceImpl @Inject constructor(
    private val catalogDao: CatalogDao,
) : CatalogLocalDataSource {

    override suspend fun getCatalog() = catalogDao.getCatalog()

    override suspend fun saveCatalog(catalog: CatalogEntity) = catalogDao.insert(catalog)

    override suspend fun removeCatalog(catalog: CatalogEntity) = catalogDao.delete(catalog)

}