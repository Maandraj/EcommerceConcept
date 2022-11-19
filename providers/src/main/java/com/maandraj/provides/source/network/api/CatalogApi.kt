package com.maandraj.provides.source.network.api

import com.maandraj.core.utils.result.EResult
import com.maandraj.models.remote.catalog.CatalogModel
import retrofit2.http.GET

interface CatalogApi {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getCatalog() : EResult<CatalogModel>

}