package core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun DevScionWebTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalDpSize provides DpSize(),
        LocalFontSize provides FontSize(),
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