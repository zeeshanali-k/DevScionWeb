package core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

@Composable
fun DevScionWebTheme(
    windowSize: WindowSize,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalDpSize provides DpSize(),
        LocalFontSize provides getWindowBasedFont(windowSize),
        LocalWindowSize provides windowSize
    ) {
        MaterialTheme(
            content = content,
            colors = lightColors(
                primary = AppColors.PRIMARY,
                background = AppColors.BACKGROUND,
                onBackground = AppColors.ON_BACKGROUND,
                secondary = AppColors.BTN_COLOR,
                onSecondary = AppColors.TEXT_COLOR,
                surface = AppColors.GREY_TEXT_COLOR,
                error = AppColors.ERROR
            )
        )
    }
}


val LocalWindowSize = compositionLocalOf {
    WindowSize.COMPACT
}

val MaterialTheme.window: WindowSize
    @Composable
    @ReadOnlyComposable
    get() = LocalWindowSize.current