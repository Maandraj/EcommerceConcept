package com.maandraj.ecommerceconcept.di.module.catalog.source

import com.maandraj.data.catalog.source.remote.catalog.CatalogRemoteDataSource
import com.maandraj.data.catalog.source.remote.catalog.CatalogRemoteDataSourceImpl
import com.maandraj.provides.source.network.api.CatalogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RemoteCatalogModule {

    @Singleton
    @Provides
    fun provideCatalogService(
        retrofit: Retrofit,
    ): CatalogApi = retrofit.create(CatalogApi::class.java)

    @Singleton
    @Provides
    fun provideCatalogRemoteDataSourceImpl(
        catalogApi: CatalogApi,
    ): CatalogRemoteDataSource = CatalogRemoteDataSourceImpl(catalogApi)
}