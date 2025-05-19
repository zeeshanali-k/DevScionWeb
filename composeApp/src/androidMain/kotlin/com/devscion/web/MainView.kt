package com.devscion.web

import App
import androidx.compose.runtime.Composable
import core.theme.WindowSize

@Composable
fun MainView() {
    App(windowSize = WindowSize.COMPACT)
}