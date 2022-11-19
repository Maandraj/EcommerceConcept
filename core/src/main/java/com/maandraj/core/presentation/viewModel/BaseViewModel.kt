package com.maandraj.core.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maandraj.core.presentation.IBaseViewModel
import com.maandraj.core.utils.result.EResult

open class BaseViewModel : IBaseViewModel, ViewModel() {
    override val loadingLiveData: MutableLiveData<Boolean>? = MutableLiveData()
    override val errorLiveData: MutableLiveData<EResult.Failure> = MutableLiveData()
}