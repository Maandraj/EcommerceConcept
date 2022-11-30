package com.maandraj.ecommerceconcept.di.module.catalog

import com.maandraj.data.catalog.local.source.CatalogLocalDataSource
import com.maandraj.data.catalog.remote.source.CatalogRemoteDataSource
import com.maandraj.data.catalog.repository.CatalogRepository
import com.maandraj.data.catalog.repository.CatalogRepositoryImpl
import com.maandraj.domain.catalog.usecase.CatalogUseCase
import com.maandraj.domain.catalog.usecase.CatalogUseCaseImpl
import dagger.Module
import dagger.Provides

@Module(includes = [LocalCatalogModule::class, RemoteCatalogModule::class])
class CatalogModule {

    @Provides
    fun provideCatalogRepositoryImpl(
        catalogRemoteDataSource: CatalogRemoteDataSource,
        catalogLocalDataSource: CatalogLocalDataSource,
    ): CatalogRepository = CatalogRepositoryImpl(
        remoteDataSource = catalogRemoteDataSource,
        localDataSource = catalogLocalDataSource
    )

    @Provides
    fun provideCatalogUseCase(
        catalogRepository: CatalogRepository,
    ): CatalogUseCase = CatalogUseCaseImpl(catalogRepository)

}