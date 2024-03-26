package core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


data class DpSize(
    val small: TextUnit = 8.sp,
    val medium: TextUnit = 12.sp,
    val standard: TextUnit = 14.sp,
    val large: TextUnit = 17.sp,
    val xLarge: TextUnit = 22.sp,
)

val LocalDpSize = compositionLocalOf { DpSize() }

val MaterialTheme.dpSize: DpSize
    @Composable
    @ReadOnlyComposable
    get() = LocalDpSize.current

data class FontSize(
    val small: TextUnit = 12.sp,
    val mSmall: TextUnit = 15.sp,
    val medium: TextUnit = 17.sp,
    val standard: TextUnit = 22.sp,
    val large: TextUnit = 28.sp,
    val mLarge: TextUnit = 25.sp,
    val xLarge: TextUnit = 35.sp,
    val xxLarge: TextUnit = 45.sp,
    val xxxLarge: TextUnit = 55.sp,
)

val LocalFontSize = compositionLocalOf { FontSize() }

val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current