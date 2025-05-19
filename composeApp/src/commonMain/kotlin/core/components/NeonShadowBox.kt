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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.theme.AppColors

@Composable
fun NeonShadowBox(
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    radius: Dp = 6.dp,
    color: Color = AppColors.NEON,
    backgroundColor: Color = Color.Transparent,
    content: @Composable () -> Unit
) {

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
        modifier.drawWithCache {
            onDrawWithContent {
                drawNeonStroke(
                    radius = radius,
                    color = color,
                    backgroundColor = backgroundColor
                )
                drawContent()
            }
        }.border(
            with(LocalDensity.current) {
                2.dp
            },
            brush = Brush.linearGradient(listOf(color1.value, color2.value)),
            shape = RoundedCornerShape(radius)
        ).then(innerModifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

expect fun ContentDrawScope.drawNeonStroke(radius: Dp, color: Color, backgroundColor: Color)