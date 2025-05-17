package core.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.theme.AppColors

//import org.jetbrains.skia.FilterBlurMode
//import org.jetbrains.skia.MaskFilter

@Composable
fun NeonShadowBox(
    modifier: Modifier = Modifier,
    radius: Dp = 6.dp,
    color: Color = AppColors.NEON,
    content: @Composable () -> Unit
) {
    var screenWidth by remember {
        mutableIntStateOf(0)
    }

    val infiniteTransition = rememberInfiniteTransition()
    val color1 = infiniteTransition.animateColor(
        Color.White.copy(alpha = 0.75f), color, infiniteRepeatable(
            tween(1500), repeatMode = RepeatMode.Reverse,
        )
    )
    val color2 = infiniteTransition.animateColor(
        color, Color.White.copy(alpha = 0.75f), infiniteRepeatable(
            tween(1500), repeatMode = RepeatMode.Reverse,
        )
    )

    Box(
        modifier.drawWithContent {
            drawContent()
            drawNeonStroke(
                radius = radius,
                color = color
            )
        }.onGloballyPositioned {
            screenWidth = it.size.width
        }.border(
            with(LocalDensity.current) {
                1.dp
            },
            brush = Brush.linearGradient(listOf(color1.value, color2.value)),
            shape = RoundedCornerShape(radius)
        ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

expect fun ContentDrawScope.drawNeonStroke(radius: Dp, color: Color)