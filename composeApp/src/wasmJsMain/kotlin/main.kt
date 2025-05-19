@file:OptIn(ExperimentalBrowserHistoryApi::class)

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.navigation.ExperimentalBrowserHistoryApi
import core.theme.LocalWindowSize
import core.theme.WindowSize
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        val windowSize = remember {
            WindowSize.basedOnWidth(window.innerWidth.toDouble())
        }
        CompositionLocalProvider(LocalWindowSize provides windowSize) {
            App(
                windowSize,
            )
        }
    }
}