package core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.theme.AppColors
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

@Composable
fun NeonShadowBox(
    modifier: Modifier = Modifier, radius: Dp = 6.dp,
    color: Color = AppColors.NEON,
    content: @Composable () -> Unit
) {
//    CompositionLocalProvider(
//        LocalMinimumTouchTargetEnforcement provides false,
//    ) {
    Box(
        modifier.drawWithContent {
            drawContent()
            drawNeonStroke(
                radius = radius,
                color = color
            )
        },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
//    }
}

fun ContentDrawScope.drawNeonStroke(radius: Dp, color: Color) {
    this.drawIntoCanvas {
        val paint =
            Paint().apply {
                style = PaintingStyle.Fill
//                strokeWidth = 1f
            }

        val frameworkPaint =
            paint.asFrameworkPaint()


        this.drawIntoCanvas {
            frameworkPaint.color = color.copy(alpha = 1f).toArgb()
            frameworkPaint.maskFilter = MaskFilter.makeBlur(FilterBlurMode.OUTER, 40f)
            it.drawRoundRect(
                left = 0f,
                right = size.width,
                bottom = size.height,
                top = 0f,
                radiusY = radius.toPx(),
                radiusX = radius.toPx(),
                paint = paint
            )
//            drawRoundRect(
//                color = neonColor.copy(alpha = 0.25f),
//                size = size,
////                cornerRadius = CornerRadius(radius.toPx(), radius.toPx()),
//                style = Fill
//            )
        }
    }
}