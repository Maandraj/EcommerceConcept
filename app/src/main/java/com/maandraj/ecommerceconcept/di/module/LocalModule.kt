package com.maandraj.ecommerceconcept.di.module

import android.content.Context
import androidx.room.Room
import com.maandraj.data.catalog.local.database.EccomerceDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Singleton
    @Provides
    fun provideDatabase(
        app: Context,
    ) = Room.databaseBuilder(
        app,
        EccomerceDataBase::class.java,
        "EccomerceDataBase"
    ).build()
}