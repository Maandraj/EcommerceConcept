package com.maandraj.core.data.base.repository

import com.maandraj.core.data.base.source.LocalDataSource

interface BaseLocalRepository<out L : LocalDataSource> {
    val localDataSource : L
}