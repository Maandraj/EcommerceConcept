package com.maandraj.ecommerceconcept.di.module

import com.maandraj.ecommerceconcept.di.module.catalog.source.LocalCatalogModule
import com.maandraj.ecommerceconcept.di.module.catalog.source.RemoteCatalogModule
import dagger.Module

@Module(includes = [
    LocalModule::class,
    NetworkModule::class,
    LocalCatalogModule::class,
    RemoteCatalogModule::class,
])
class BaseModule