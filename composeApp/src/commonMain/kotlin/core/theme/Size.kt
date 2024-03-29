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

abstract class FontSize(
    val small: TextUnit,
    val mSmall: TextUnit,
    val medium: TextUnit,
    val standard: TextUnit,
    val large: TextUnit,
    val mLarge: TextUnit,
    val xLarge: TextUnit,
    val xxLarge: TextUnit,
    val xxxLarge: TextUnit,
)

class MobileFontSize() : FontSize(
    small = 17.sp,
    mSmall = 20.sp,
    medium = 22.sp,
    standard = 27.sp,
    large = 33.sp,
    mLarge = 30.sp,
    xLarge = 40.sp,
    xxLarge = 50.sp,
    xxxLarge = 60.sp,
)

class ExpandedFontSize() : FontSize(
    small = 12.sp,
    mSmall = 15.sp,
    medium = 17.sp,
    standard = 22.sp,
    large = 28.sp,
    mLarge = 25.sp,
    xLarge = 35.sp,
    xxLarge = 45.sp,
    xxxLarge = 55.sp,
)

fun getWindowBasedFont(windowSize: WindowSize): FontSize {
    return if (windowSize == WindowSize.EXPANDED) {
        ExpandedFontSize()
    } else {
        MobileFontSize()
    }
}

val LocalFontSize = compositionLocalOf<FontSize> { ExpandedFontSize() }

val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current