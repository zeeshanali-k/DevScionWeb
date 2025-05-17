package core.components

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp

actual fun ContentDrawScope.drawNeonStroke(
    radius: Dp,
    color: Color
) {
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
            frameworkPaint.maskFilter = BlurMaskFilter(40f, BlurMaskFilter.Blur.OUTER)
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