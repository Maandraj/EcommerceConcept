package com.maandraj.data.catalog.repository

import com.maandraj.core.utils.result.EResult
import com.maandraj.core.utils.result.convertTo
import com.maandraj.data.catalog.local.source.CatalogLocalDataSource
import com.maandraj.data.catalog.remote.source.CatalogRemoteDataSource
import com.maandraj.models.ui.catalog.CatalogData
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    override val localDataSource: CatalogLocalDataSource,
    override val remoteDataSource: CatalogRemoteDataSource,
) : CatalogRepository {
    override suspend fun getCatalog(): EResult<CatalogData> {
        return remoteDataSource.getCatalog().convertTo()
    }
}
