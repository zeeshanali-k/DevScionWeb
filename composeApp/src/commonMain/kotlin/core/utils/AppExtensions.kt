package core.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.Vertical() {
    Spacer(Modifier.height(this))
}

@Composable
fun Dp.Horizontal() {
    Spacer(Modifier.width(this))
}