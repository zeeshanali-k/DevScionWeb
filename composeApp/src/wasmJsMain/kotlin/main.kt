@file:OptIn(ExperimentalBrowserHistoryApi::class)

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.rememberNavController
import core.theme.LocalWindowSize
import core.theme.WindowSize
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val navController = rememberNavController()
        val windowSize = remember {
            WindowSize.basedOnWidth(window.innerWidth.toDouble())
        }
        CompositionLocalProvider(LocalWindowSize provides windowSize) {
            App(
                windowSize,
                navController
            )
        }
        LaunchedEffect(Unit) {
            window.bindToNavigation(navController)
        }
    }
}