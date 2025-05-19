package core.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter


actual fun ContentDrawScope.drawTranslucentNeonStroke(
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
            frameworkPaint.color = Color(0xFF181d20).toArgb()
            frameworkPaint.maskFilter = MaskFilter.makeBlur(FilterBlurMode.INNER, 80f)
            it.drawRoundRect(
                left = 0f,
                right = size.width,
                bottom = size.height,
                top = 0f,
                radiusY = radius.toPx(),
                radiusX = radius.toPx(),
                paint = paint
            )
        }
    }
}