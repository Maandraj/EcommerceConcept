package com.maandraj.ecommerceconcept.di

import android.content.Context
import com.maandraj.data.catalog.repository.CatalogRepository
import com.maandraj.ecommerceconcept.di.module.BaseModule
import com.maandraj.ecommerceconcept.presentation.activity.MainActivity
import com.maandraj.explorer.di.ExplorerDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@MainScope
@Component(modules = [BaseModule::class])
interface MainComponent : ExplorerDeps {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): MainComponent
    }

    override val catalogRepository: CatalogRepository
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class MainScope