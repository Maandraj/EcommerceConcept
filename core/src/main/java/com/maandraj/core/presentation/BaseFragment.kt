package com.maandraj.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.maandraj.core.R
import com.maandraj.core.utils.extension.hide
import com.maandraj.core.utils.extension.hideKeyboard
import com.maandraj.core.utils.extension.show
import com.maandraj.core.utils.extension.toast

abstract class BaseFragment<VM : IBaseViewModel> : Fragment(), IBaseFragment<VM> {

    override val viewModel: VM? = null

    override val navController: NavController
        get() = this.findNavController()

    open val contentViewLayout: View? = null

    open val loadingViewLayout: View?
        get() = this.view?.findViewById(R.id.loading_layout)

    open val errorViewLayout: View?
        get() = this.view?.findViewById(R.id.error_layout)

    protected open val canPressBack: Boolean = false

    override fun onBackPressed(): Boolean {
        return if (!canPressBack) true else navController.popBackStack()
    }

    override fun showToast(message: Any, interval: Int) {
        hideLoading()
        toast(message, interval)
    }

    private fun observableState() {
        viewModel?.errorLiveData?.observe(viewLifecycleOwner) {
            showLayoutError()
            toast(it.message.toString())
        }
        viewModel?.loadingLiveData?.observe(viewLifecycleOwner) {
            if (it)
                showLayoutLoading()
            else
                hideLayoutLoading()
        }
    }

    override fun showError() {
        showLayoutError()
    }

    private fun showLayoutError() {
        hideKeyboard()
        contentViewLayout?.hide()
        loadingViewLayout?.hide()
        errorViewLayout?.show()
    }

    override fun showLoading() {
        showLayoutLoading()
    }

    private fun showLayoutLoading() {
        hideKeyboard()
        contentViewLayout?.hide()
        errorViewLayout?.hide()
        loadingViewLayout?.show()
    }


    override fun hideLoading() {
        hideLayoutLoading()
    }

    private fun hideLayoutLoading() {
        hideKeyboard()
        loadingViewLayout?.hide()
        errorViewLayout?.hide()
        contentViewLayout?.show()
    }

    override fun initBinding() = Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        observableState()
    }

    override fun onDestroyView() {
        onBackPressedCallback.isEnabled = false
        viewModel?.apply {
            loadingLiveData?.removeObservers(viewLifecycleOwner)
            errorLiveData.removeObservers(viewLifecycleOwner)
        }
        super.onDestroyView()
    }

    protected open val onBackPressedCallback by lazy() {
        object : OnBackPressedCallback(canPressBack) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    }


}