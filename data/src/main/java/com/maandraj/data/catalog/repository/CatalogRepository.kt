package com.maandraj.data.catalog.repository

import com.maandraj.core.data.base.repository.BaseRepository
import com.maandraj.core.utils.result.EResult
import com.maandraj.data.catalog.source.local.catalog.CatalogLocalDataSource
import com.maandraj.data.catalog.source.remote.catalog.CatalogRemoteDataSource
import com.maandraj.models.ui.catalog.CatalogData

interface CatalogRepository : BaseRepository<CatalogRemoteDataSource, CatalogLocalDataSource> {
    suspend fun getCatalog(): EResult<CatalogData>
}

