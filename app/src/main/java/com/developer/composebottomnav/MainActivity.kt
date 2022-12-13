package com.developer.composebottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.developer.composebottomnav.navigation.Screen
import com.developer.composebottomnav.navigation.SetupNavGraph
import com.developer.composebottomnav.ui.theme.ComposeBottomNavTheme

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navHostController = rememberNavController()
                    BottomNavScreen(navHostController)
                }
            }
        }
    }
}

sealed class BottomNav(var icon: ImageVector, var label: String, var route: String){
    object HomeScreen: BottomNav(Icons.Filled.Home, "HOME", "home_bottom_nav")
    object DetailScreen: BottomNav(Icons.Filled.Info, "DETAIL", "detail_bottom_nav")
}

val listBottom: () -> List<BottomNav> = {
    listOf(
        BottomNav.HomeScreen,
        BottomNav.DetailScreen
    )
}

@Composable
fun BottomNavScreen(navHostController: NavHostController) {
    Scaffold (
        bottomBar = {
            var selectedItemIndex by remember{
                mutableStateOf(0)
            }
            BottomNavigation() {
                listBottom().forEachIndexed { index, screen ->
                    BottomNavigationItem(selected = selectedItemIndex == index,
                        onClick = {selectedItemIndex = index; navHostController.navigate(screen.route)},
                        icon = {
                            Icon(imageVector = screen.icon,
                                contentDescription = screen.label)
                        },
                    alwaysShowLabel = selectedItemIndex == index,
                    label = { Text(text = screen.label)})
                }
            }
        }
    ) {
        SetupNavGraph(navController = navHostController)
    }
}

@Preview
@Composable
fun Preview() {
    BottomNavScreen(rememberNavController())
}
