import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import core.theme.WindowSize

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(canvasElementId = "ComposeTarget") {
        App(
            WindowSize.basedOnWidth(getWidth())
        )
    }
}


fun getWidth() : Double =
    js("window.innerWidth")