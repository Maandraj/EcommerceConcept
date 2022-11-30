package com.maandraj.core.presentation

import androidx.lifecycle.MutableLiveData
import com.maandraj.core.utils.result.EResult

interface IBaseViewModel {
    val loadingLiveData: MutableLiveData<Boolean>?
    val errorLiveData: MutableLiveData<EResult.Failure>
}