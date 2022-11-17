package com.maandraj.provides.source.network.api

import retrofit2.http.GET

interface CatalogApi {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getCatalog()

}