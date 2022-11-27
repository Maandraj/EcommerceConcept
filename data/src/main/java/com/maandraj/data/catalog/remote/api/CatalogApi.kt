package com.maandraj.data.catalog.remote.api

import com.maandraj.models.remote.catalog.CatalogModel
import retrofit2.Response
import retrofit2.http.GET

interface CatalogApi {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getCatalog(): Response<CatalogModel>

}