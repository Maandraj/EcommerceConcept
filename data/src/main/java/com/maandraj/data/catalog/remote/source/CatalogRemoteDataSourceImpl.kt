package com.maandraj.data.catalog.remote.source

import com.maandraj.core.utils.result.EResult
import com.maandraj.core.utils.result.emptyResult
import com.maandraj.core.utils.result.errorResult
import com.maandraj.core.utils.result.toSuccessResult
import com.maandraj.data.catalog.remote.api.CatalogApi
import com.maandraj.models.remote.catalog.CatalogModel
import javax.inject.Inject

class CatalogRemoteDataSourceImpl @Inject constructor(
    private val catalogApi: CatalogApi,
) : CatalogRemoteDataSource {

    override suspend fun getCatalog(): EResult<CatalogModel> {
        try {
            catalogApi.getCatalog().apply {
                return if (isSuccessful)
                    body().toSuccessResult()
                else
                    errorBody()?.errorResult(message()) ?: emptyResult()
            }
        } catch (ex: Exception) {
            // TODO надо сделать нормальную обработку ошибок + создать внутренние исключения + локализация
            return errorResult("Какой-то сверхразум все сломал :(", ex)
        }
    }

}