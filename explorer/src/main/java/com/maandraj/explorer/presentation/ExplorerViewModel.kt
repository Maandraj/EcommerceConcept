package com.maandraj.explorer.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maandraj.core.presentation.viewModel.BaseViewModel
import com.maandraj.core.utils.extension.asLiveData
import com.maandraj.core.utils.result.applyIfError
import com.maandraj.core.utils.result.applyIfSuccess
import com.maandraj.domain.catalog.usecase.CatalogUseCase
import com.maandraj.explorer.di.DaggerExplorerComponent
import com.maandraj.explorer.di.ExplorerComponent
import com.maandraj.explorer.di.ExplorerDepsProvider
import com.maandraj.models.ui.catalog.CatalogData
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ExplorerViewModel @Inject constructor(
    private val catalogUseCase: CatalogUseCase,
) : BaseViewModel() {

    private val _catalog = MutableLiveData<CatalogData>()
    val catalog = _catalog.asLiveData()

    fun getCatalog() = viewModelScope.launch {
        catalogUseCase().applyIfSuccess {
            _catalog.postValue(it)
        }.applyIfError {
            errorLiveData.postValue(it)
        }
    }

    class Factory @Inject constructor(
        private val catalogUseCase: Provider<CatalogUseCase>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == ExplorerViewModel::class.java)
            return ExplorerViewModel(catalogUseCase.get()) as T
        }
    }
}

class ExplorerComponentViewModel : ViewModel() {
    val explorerComponent: ExplorerComponent =
        DaggerExplorerComponent.builder().explorerDeps(ExplorerDepsProvider.deps).build()
}