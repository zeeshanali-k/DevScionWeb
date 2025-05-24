package home.presentation.components.social

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.StandardBoldText
import core.theme.spacing
import core.utils.Horizontal
import home.domain.model.Social
import org.jetbrains.compose.resources.painterResource


@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    social: Social,
    maxWidth: Float = 300f,
    onClick: () -> Unit,
) {
    val itemWidthTarget = remember {
        mutableStateOf(0f)
    }
    val btnWidth =
        animateDpAsState(
            targetValue = itemWidthTarget.value.dp,
            animationSpec = tween(
                250, delayMillis = 10, easing = EaseOut
            ), label = ""
        )

    LaunchedEffect(Unit) {
        itemWidthTarget.value = maxWidth
    }

    NeonShadowBox(
        color = AppColors.NEON2,
        modifier = modifier.width(
            btnWidth.value
        ).clickable {
            onClick()
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.standard)
        ) {
            Image(
                painter = painterResource(social.icon),
                contentDescription = "linkedin",
                Modifier.size(20.dp)
            )
            MaterialTheme.spacing.mSmall.Horizontal()
            AnimatedVisibility(visible = btnWidth.value.value == maxWidth) {
                StandardBoldText(
                    text = social.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}