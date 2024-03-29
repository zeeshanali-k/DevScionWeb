package core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//For Web
data class Spacing(
    val xSmall: Dp = 7.dp,
    val mSmall: Dp = 10.dp,
    val small: Dp = 15.dp,
    val medium: Dp = 20.dp,
    val standard: Dp = 25.dp,
    val large: Dp = 35.dp,
    val xLarge: Dp = 50.dp,
    val xxLarge: Dp = 60.dp,
    val xxxLarge: Dp = 70.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
