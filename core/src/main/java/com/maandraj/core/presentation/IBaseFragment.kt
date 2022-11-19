package com.maandraj.core.presentation

import android.widget.Toast
import androidx.navigation.NavController

interface IBaseFragment<VM : IBaseViewModel> {

    val navController: NavController?

    val viewModel: VM?
    val layoutId: Int

    val toolbarTitle: String
    val toolbarTitleResId: Int?
    val gravityToolbarTitle: Int

    fun onBackPressed(): Boolean

    fun onToolbarBackPressed()

    fun initBinding()

    fun hideLoading()
    fun showLoading()

    fun showToast(message: Any, interval: Int = Toast.LENGTH_SHORT)

}