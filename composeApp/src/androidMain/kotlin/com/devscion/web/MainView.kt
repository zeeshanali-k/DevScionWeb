package com.devscion.web

import App
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import core.theme.WindowSize

@Composable
fun MainView() {
    val navController = rememberNavController()
    App(navController = navController, windowSize = WindowSize.COMPACT)
}