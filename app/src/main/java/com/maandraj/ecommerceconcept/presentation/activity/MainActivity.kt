package com.maandraj.ecommerceconcept.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.maandraj.ecommerceconcept.R
import com.maandraj.navigation.ENavigator
import com.maandraj.navigation.NavigationFlow
import com.maandraj.navigation.ToFlowNavigatable

class MainActivity : AppCompatActivity(R.layout.activity_main), ToFlowNavigatable {
    private var navigator: ENavigator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        navigator = ENavigator(navController)
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator?.navigatorToFlow(flow)
    }
}