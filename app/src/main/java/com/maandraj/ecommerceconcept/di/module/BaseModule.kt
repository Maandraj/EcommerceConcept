package com.maandraj.ecommerceconcept.di.module

import android.app.Application
import android.content.Context
import com.maandraj.ecommerceconcept.App
import com.maandraj.ecommerceconcept.di.module.catalog.CatalogModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [
    LocalModule::class,
    NetworkModule::class,
    CatalogModule::class
])
 class BaseModule() {


}