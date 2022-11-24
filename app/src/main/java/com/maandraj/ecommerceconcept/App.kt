package com.maandraj.ecommerceconcept

import android.app.Application
import com.maandraj.provides.di.component.BaseComponent
import com.maandraj.provides.di.component.BaseComponentProvider
import com.maandraj.provides.di.component.DaggerBaseComponent

class App : Application(), BaseComponentProvider {

    lateinit var baseComponent: BaseComponent

    override fun onCreate() {
        super.onCreate()

        baseComponent = DaggerBaseComponent
            .builder()
            .build()
        baseComponent.application(this)
    }


    override fun provideBaseComponent(): BaseComponent {
        return baseComponent
    }
}