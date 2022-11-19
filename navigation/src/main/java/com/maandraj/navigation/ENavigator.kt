package com.maandraj.navigation

import androidx.annotation.MainThread
import androidx.navigation.NavController

class ENavigator(
    private val navController: NavController
){
    @MainThread
    fun navigatorToFlow(navigationFlow: NavigationFlow) = when(navigationFlow){
        is NavigationFlow.HostTabFlow -> navController.navigate(MainNavGraphDirections.actionGlobalHostTabFlow())

        is NavigationFlow.MainFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMainFlow())

    }
}