package com.developer.composebottomnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphNavigator
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.developer.composebottomnav.BottomNav
import com.developer.composebottomnav.screen.DetailScreen
import com.developer.composebottomnav.screen.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.DetailScreen.route){
            DetailScreen(navController = navController)
        }

        composable(BottomNav.HomeScreen.route){
            HomeScreen(navController = navController)
        }

        composable(BottomNav.DetailScreen.route){
            DetailScreen(navController = navController)
        }
    }
}