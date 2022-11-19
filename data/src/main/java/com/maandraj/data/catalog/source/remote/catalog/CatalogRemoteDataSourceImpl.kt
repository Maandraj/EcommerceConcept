package com.maandraj.data.catalog.source.remote.catalog

import com.maandraj.core.utils.result.EResult
import com.maandraj.models.remote.catalog.CatalogModel
import com.maandraj.provides.source.network.api.CatalogApi
import javax.inject.Inject

class CatalogRemoteDataSourceImpl @Inject constructor(
    private val catalogApi: CatalogApi,
) : CatalogRemoteDataSource {
    override suspend fun getCatalog(): EResult<CatalogModel> = catalogApi.getCatalog()
}