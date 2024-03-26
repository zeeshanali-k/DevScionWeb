package core.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.max
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
    body1 = TextStyle(
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
fun SmallText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
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
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.small
        ),
    )
}


@Composable
fun MSmallBoldText(
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
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.mSmall
        ),
    )
}


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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.mSmall
        ),
    )
}

@Composable
fun SmallGreyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = color,
            fontSize = MaterialTheme.fontSize.small
        ),
    )
}

@Composable
fun SmallGreyBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.small
        ),
    )
}

@Composable
fun MSmallGreyBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.mSmall
        ),
    )
}

@Composable
fun SmallPrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = color,
            fontSize = MaterialTheme.fontSize.small
        ),
    )
}

@Composable
fun SmallPrimaryBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.small
        ),
    )
}

@Composable
fun MSmallPrimaryBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.mSmall
        ),
    )
}

@Composable
fun StandardGreyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = color,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun StandardGreyBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.standard
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
    color: Color = MaterialTheme.colors.onSecondary,
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
fun MediumGreyText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int? = null,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface,
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
fun MediumGreyBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSurface,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun MediumPrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Normal,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun MediumPrimarySemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.SemiBold,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun MediumPrimaryBoldText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int? = null,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.primary,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        maxLines = maxLines ?: Int.MAX_VALUE,
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
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSecondary,
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
fun MediumBoldText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int? = null,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.onSecondary,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        maxLines = maxLines ?: Int.MAX_VALUE,
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
fun MediumBoldSuccessText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = AppColors.GREEN,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun LargeBoldSuccessText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = AppColors.GREEN,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.large
        ),
    )
}

@Composable
fun MediumBoldErrorText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.error,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun LargeBoldErrorText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colors.error,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontFamily = interFamily,
            fontWeight = FontWeight.Bold,
            color = color,
            fontSize = MaterialTheme.fontSize.large
        ),
    )
}

@Composable
fun StandardErrorText(
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
            color = MaterialTheme.colors.error,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun StandardErrorBoldText(
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
            color = MaterialTheme.colors.error,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun MediumErrorText(
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
            color = MaterialTheme.colors.error,
            fontSize = MaterialTheme.fontSize.medium
        ),
    )
}

@Composable
fun LargeText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.large
        ),
    )
}

@Composable
fun XLargeText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.xLarge
        ),
    )
}

@Composable
fun XLargeBoldText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.xLarge
        ),
    )
}

@Composable
fun XLargeBoldBlackText(
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
            color = Color.Black,
            fontSize = MaterialTheme.fontSize.xLarge
        ),
    )
}

@Composable
fun XXLargeText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.xxLarge
        ),
    )
}

@Composable
fun XXLargeBoldText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.xxLarge
        ),
    )
}

@Composable
fun XXXLargeText(
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.xxxLarge
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun StandardBlackBoldText(
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
            color = Color.Black,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun StandardPrimaryBoldText(
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
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.fontSize.standard
        ),
    )
}

@Composable
fun LargePrimaryBoldText(
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
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.fontSize.large
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
            color = MaterialTheme.colors.onSecondary,
            fontSize = MaterialTheme.fontSize.large
        ),
    )
}

