package com.maandraj.navigation

import androidx.annotation.MainThread
import androidx.navigation.NavController
import javax.inject.Inject

class ENavigator @Inject constructor(
    private val navController: NavController
){
    @MainThread
    fun navigatorToFlow(navigationFlow: NavigationFlow) = when(navigationFlow){
        is NavigationFlow.HostTabFlow -> navController.navigate(MainNavGraphDirections.actionGlobalHostTabsFlow())

        is NavigationFlow.ExplorerFlow -> navController.navigate(MainNavGraphDirections.actionGlobalExplorerFlow())

        is NavigationFlow.MainFlow -> navController.navigate(MainNavGraphDirections.actionGlobalMainFlow())

    }
}