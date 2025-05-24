package core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

val interFamily = FontFamily.Monospace
//    FontFamily(
//    Font(R.font.inter_regular, FontWeight.Normal),
//    Font(R.font.inter_medium, FontWeight.Medium),
//    Font(R.font.inter_bold, FontWeight.Bold),
//    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
//    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
//)

// Set of Material typography styles to start with
//TODO
val Typography = Typography(
    bodySmall = TextStyle(
        //load font from resource
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

@Composable
fun MSmallText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int? = null,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = MaterialTheme.fontSize.mSmall
        ),
    )
}

@Composable
fun StandardBoldText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onSecondary,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines ?: Int.MAX_VALUE,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onSecondary,
    maxLines: Int? = null
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun MediumBoldWhiteText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = AppColors.WHITE,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun StandardText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun LargeBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = MaterialTheme.fontSize.large
        ),
    )
}

