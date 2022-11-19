package com.maandraj.navigation

sealed class NavigationFlow {
    object MainFlow : NavigationFlow()
    object ExplorerFlow : NavigationFlow()
    object HostTabFlow : NavigationFlow()
}