package com.maandraj.ecommerceconcept.di

import android.content.Context
import com.maandraj.domain.catalog.usecase.CatalogUseCase
import com.maandraj.ecommerceconcept.di.module.BaseModule
import com.maandraj.explorer.di.ExplorerDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseModule::class])
interface AppComponent : ExplorerDeps {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }
    override val catalogUseCase: CatalogUseCase
}

