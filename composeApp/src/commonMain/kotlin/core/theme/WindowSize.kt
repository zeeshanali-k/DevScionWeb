package core.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize {
    COMPACT,
    MEDIUM,
    EXPANDED;

    // Factory method that creates an instance of the class based on window width
    companion object {
        fun basedOnWidth(windowWidth: Double): WindowSize {
            println("Window Width: $windowWidth")
            return when {
                windowWidth < 1000 -> COMPACT
                windowWidth < 1200 -> MEDIUM
                else -> EXPANDED
            }
        }
    }
}