package com.maandraj.explorer.presentation

import androidx.lifecycle.viewModelScope
import com.maandraj.core.presentation.viewModel.BaseViewModel
import com.maandraj.domain.catalog.usecase.CatalogUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExplorerViewModel @Inject constructor(
    private val catalogUseCase: CatalogUseCase,
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            catalogUseCase()
        }
    }
}