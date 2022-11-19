package com.maandraj.data.catalog.repository

import com.maandraj.core.utils.result.EResult
import com.maandraj.core.utils.result.applyIfSuccessSuspend
import com.maandraj.core.utils.result.convertTo
import com.maandraj.data.catalog.source.local.catalog.CatalogLocalDataSource
import com.maandraj.data.catalog.source.remote.catalog.CatalogRemoteDataSource
import com.maandraj.models.local.catalog.entity.CatalogEntity
import com.maandraj.models.ui.catalog.CatalogData
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    override val localDataSource: CatalogLocalDataSource,
    override val remoteDataSource: CatalogRemoteDataSource,
) : CatalogRepository {
    override suspend fun getCatalog(): EResult<CatalogData> {
        val result: EResult<CatalogEntity> = remoteDataSource.getCatalog().convertTo()
        return result.applyIfSuccessSuspend(localDataSource::saveCatalog).convertTo()
    }
}
