package com.maandraj.data.catalog.repository

import com.maandraj.core.data.base.repository.BaseRepository
import com.maandraj.core.utils.result.EResult
import com.maandraj.data.catalog.local.source.CatalogLocalDataSource
import com.maandraj.data.catalog.remote.source.CatalogRemoteDataSource
import com.maandraj.models.ui.catalog.CatalogData

interface CatalogRepository : BaseRepository<CatalogRemoteDataSource, CatalogLocalDataSource> {
    suspend fun getCatalog(): EResult<CatalogData>
}

