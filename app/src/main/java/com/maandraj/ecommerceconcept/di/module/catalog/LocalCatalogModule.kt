package com.maandraj.ecommerceconcept.di.module.catalog

import com.maandraj.data.catalog.local.source.CatalogLocalDataSource
import com.maandraj.data.catalog.local.source.CatalogLocalDataSourceImpl
import com.maandraj.data.catalog.local.database.EccomerceDataBase
import com.maandraj.data.catalog.local.database.dao.catalog.CatalogDao
import dagger.Module
import dagger.Provides

@Module
class LocalCatalogModule {

    @Provides
    fun provideCatalogLocalDataSourceImpl(
        catalogDao: CatalogDao,
    ): CatalogLocalDataSource = CatalogLocalDataSourceImpl(catalogDao)

    @Provides
    fun provideCatalogDao(
        eccomerceDataBase: EccomerceDataBase,
    ): CatalogDao = eccomerceDataBase.getCatalogDao()
}