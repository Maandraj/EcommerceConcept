package com.maandraj.navigation

sealed class NavigationFlow {
    object MainFlow : NavigationFlow()
    object HostTabFlow : NavigationFlow()
}