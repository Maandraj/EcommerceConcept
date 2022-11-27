package com.maandraj.data.catalog.remote.source

import com.maandraj.core.data.base.source.RemoteDataSource
import com.maandraj.core.utils.result.EResult
import com.maandraj.models.remote.catalog.CatalogModel

interface CatalogRemoteDataSource : RemoteDataSource {

    suspend fun getCatalog(): EResult<CatalogModel>

}