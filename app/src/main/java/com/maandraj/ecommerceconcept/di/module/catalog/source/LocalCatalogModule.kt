package com.maandraj.ecommerceconcept.di.module.catalog.source

import com.maandraj.data.catalog.repository.CatalogRepository
import com.maandraj.data.catalog.repository.CatalogRepositoryImpl
import com.maandraj.data.catalog.source.local.catalog.CatalogLocalDataSource
import com.maandraj.data.catalog.source.local.catalog.CatalogLocalDataSourceImpl
import com.maandraj.data.catalog.source.remote.catalog.CatalogRemoteDataSource
import com.maandraj.provides.source.database.dao.catalog.CatalogDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalCatalogModule {

    @Singleton
    @Provides
    fun provideCatalogLocalDataSourceImpl(
        catalogDao: CatalogDao,
    ): CatalogLocalDataSource = CatalogLocalDataSourceImpl(catalogDao)

    @Singleton
    @Provides
    fun provideCatalogRepositoryImpl(
        catalogRemoteDataSource: CatalogRemoteDataSource,
        catalogLocalDataSource: CatalogLocalDataSource,
    ): CatalogRepository = CatalogRepositoryImpl(
        remoteDataSource = catalogRemoteDataSource,
        localDataSource = catalogLocalDataSource
    )

}