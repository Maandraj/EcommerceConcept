package com.maandraj.provides.source.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        app: Context,
    ) = Room.databaseBuilder(
        app,
        EccomerceDataBase::class.java,
        "EccomerceDataBase"
    ).build()
}