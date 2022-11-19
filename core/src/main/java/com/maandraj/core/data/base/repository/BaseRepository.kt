package com.maandraj.core.data.base.repository

import com.maandraj.core.data.base.source.LocalDataSource
import com.maandraj.core.data.base.source.RemoteDataSource

interface BaseRepository<out R : RemoteDataSource, out L : LocalDataSource>
    : BaseRemoteRepository<R>, BaseLocalRepository<L>