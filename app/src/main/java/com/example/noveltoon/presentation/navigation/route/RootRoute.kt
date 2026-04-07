package com.example.noveltoon.presentation.navigation.route

sealed class RootRoute(val route: String) {

    data object MainGraph : RootRoute("main_graph")

    data object AuthGraph : RootRoute("auth_graph")

}