package com.maandraj.core.presentation

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.maandraj.core.R
import com.maandraj.core.utils.*

abstract class BaseFragment<VM : IBaseViewModel> : Fragment(), IBaseFragment<VM> {

    override val viewModel: VM? = null

    //Toolbar
    override val toolbarTitle: String = ""
    override val toolbarTitleResId: Int? = null
    override val gravityToolbarTitle: Int = Gravity.CENTER

    override val navController: NavController
        get() = this.findNavController()

    open val contentViewLayout: View? = null

    open val loadingViewLayout: View?
        get() = this.view?.findViewById(R.id.loadingLayout)

    protected open val toolbarView: Toolbar?
        get() = this.view?.findViewById(R.id.toolbarLayout)
    protected open val toolbarBackButtonResId: Int
        get() = R.drawable.back_button_37dp

    protected open val needBackButton: Boolean = false
    protected open val canPressBack: Boolean = false


    override fun onBackPressed(): Boolean {
        return if (!canPressBack) true else navController.popBackStack()
    }

    override fun onToolbarBackPressed() {
        navController.popBackStack()
    }

    override fun showToast(message: Any, interval: Int) {
        hideLoading()
        toast(message, interval)
    }

    override fun showLoading() {
        showLayoutLoading()
    }

    protected fun showLayoutLoading() {
        hideKeyboard()
        contentViewLayout?.hide()
        loadingViewLayout?.show()
    }

    override fun hideLoading() {
        hideLayoutLoading()
    }

    protected fun hideLayoutLoading() {
        hideKeyboard()
        loadingViewLayout?.hide()
        contentViewLayout?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(layoutId, container, false)

    override fun onDestroyView() {
        onBackPressedCallback.isEnabled = false
        viewModel?.apply {
            loadingLiveData?.removeObservers(viewLifecycleOwner)
            errorLiveData.removeObservers(viewLifecycleOwner)
        }
        super.onDestroyView()
    }

    protected open fun showToolbar() {
        toolbarView?.let { toolbar ->
            val titleMarginEnd =
                dimenPixel(if (needBackButton) R.dimen.size_margin_toolbar_back_button_dp
                else R.dimen.size_dimen_toolbar_dp)
            initToolbarTitle(toolbar, titleMarginEnd)
            if (needBackButton) {
                toolbar.setNavigationIcon(toolbarBackButtonResId)
                toolbar.setNavigationOnClickListener {
                    onToolbarBackPressed()
                }
            }
        }
        if (canPressBack) {
            onBackPressedCallback.isEnabled = true
            this.requireActivity()
                .onBackPressedDispatcher
                .addCallback(viewLifecycleOwner, onBackPressedCallback)
        } else {
            onBackPressedCallback.isEnabled = false
        }
    }

    protected open val onBackPressedCallback by lazy() {
        object : OnBackPressedCallback(canPressBack) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }
    }


}