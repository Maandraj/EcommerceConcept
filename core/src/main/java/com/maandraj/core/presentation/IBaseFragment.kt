package com.maandraj.core.presentation

import android.widget.Toast
import androidx.navigation.NavController

interface IBaseFragment<VM : IBaseViewModel> {

    val navController: NavController?

    val viewModel: VM?
    val layoutId: Int

    fun onBackPressed(): Boolean

    fun initBinding()

    fun hideLoading()
    fun showLoading()
    fun showError()

    fun showToast(message: Any, interval: Int = Toast.LENGTH_SHORT)

}