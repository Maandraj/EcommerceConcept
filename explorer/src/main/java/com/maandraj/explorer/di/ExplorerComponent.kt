package com.maandraj.explorer.di

import androidx.annotation.RestrictTo
import com.maandraj.data.catalog.repository.CatalogRepository
import com.maandraj.explorer.presentation.ExplorerFragment
import dagger.Component
import javax.inject.Scope
import kotlin.properties.Delegates

@ExplorerScope
@Component(dependencies = [ExplorerDeps::class])
interface ExplorerComponent {

    fun inject(explorerFragment: ExplorerFragment)

    @Component.Builder
    interface Builder {
        fun explorerDeps(explorerDeps: ExplorerDeps): Builder

        fun build(): ExplorerComponent
    }
}

interface ExplorerDeps {
    val catalogRepository: CatalogRepository
}

interface ExplorerDepsProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: ExplorerDeps

    companion object : ExplorerDepsProvider by ExplorerDepsStore
}

object ExplorerDepsStore : ExplorerDepsProvider {
    override var deps: ExplorerDeps by Delegates.notNull()
}

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class ExplorerScope