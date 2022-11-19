package com.maandraj.domain.catalog.usecase

import com.maandraj.core.domain.UseCase
import com.maandraj.core.utils.result.EResult
import com.maandraj.data.catalog.repository.CatalogRepository
import com.maandraj.models.ui.catalog.CatalogData
import javax.inject.Inject

class CatalogUseCaseImpl @Inject constructor(
    private val catalogRepository: CatalogRepository
) :CatalogUseCase {
    override suspend fun invoke(): EResult<CatalogData> {
       return catalogRepository.getCatalog()
    }
}

interface CatalogUseCase : UseCase.Out<EResult<CatalogData>>