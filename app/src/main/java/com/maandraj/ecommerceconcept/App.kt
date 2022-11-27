package com.maandraj.ecommerceconcept

import android.app.Application
import com.maandraj.ecommerceconcept.di.AppComponent
import com.maandraj.ecommerceconcept.di.DaggerAppComponent
import com.maandraj.explorer.di.ExplorerDepsStore
import javax.inject.Inject

class App  : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        ExplorerDepsStore.deps = appComponent
    }
}