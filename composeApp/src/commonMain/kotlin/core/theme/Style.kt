package core.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


//Kotlin Logo Colors    Color(0xFFE24462), Color(0xFFB125EA), Color(0xFF7F52FF)
object AppColors {

    val CardGradient =
        Brush.linearGradient(
            colors = listOf(
                Color(
                    0xFF2A5470
                ),
                Color(
                    0xFF4C4177
                )
            )
        )

    val GREEN = Color.Green
    val WHITE = Color.White
    val NEON = Color(0xFFB125EA)
    val NEON2 = Color(0xFFE24462)
    val NEON3 = Color(0xFF7F52FF)

    val ERROR = Color(0xFFD73C32)

    val BACKGROUND = Color(0xFF181d20)
    val ON_BACKGROUND = Color(0xFFFFFFFF)
    val PRIMARY = Color(0xFFBB9E61)
    val BTN_COLOR = Color(0xFFE24462)
    val TEXT_COLOR = Color(0xFFFFFFFF)
    val GREY_TEXT_COLOR = Color(0xFF8D8D8D)
}