package com.maandraj.ecommerceconcept.di.module.catalog

import com.maandraj.data.catalog.remote.source.CatalogRemoteDataSource
import com.maandraj.data.catalog.remote.source.CatalogRemoteDataSourceImpl
import com.maandraj.data.catalog.remote.api.CatalogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteCatalogModule {

    @Provides
    fun provideCatalogService(
        retrofit: Retrofit,
    ): CatalogApi = retrofit.create(CatalogApi::class.java)

    @Provides
    fun provideCatalogRemoteDataSourceImpl(
        catalogApi: CatalogApi,
    ): CatalogRemoteDataSource = CatalogRemoteDataSourceImpl(catalogApi)
}