package com.developer.composebottomnav.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.developer.composebottomnav.navigation.Screen

@Composable
fun DetailScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow),
    contentAlignment = Alignment.Center){
        Text(text = "DETAIL SCREEN", modifier = Modifier.clickable{
            navController.navigate(Screen.HomeScreen.route)
        })
    }
}