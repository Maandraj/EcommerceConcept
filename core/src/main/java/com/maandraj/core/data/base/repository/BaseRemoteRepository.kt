package com.maandraj.core.data.base.repository

import com.maandraj.core.data.base.source.RemoteDataSource

interface BaseRemoteRepository<out R : RemoteDataSource>{
    val remoteDataSource : R
}