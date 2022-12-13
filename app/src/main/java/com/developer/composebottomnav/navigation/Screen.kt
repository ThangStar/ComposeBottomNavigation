package com.developer.composebottomnav.navigation

sealed class Screen(var route: String){
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen")
}
