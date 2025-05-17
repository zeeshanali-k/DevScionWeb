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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.StandardBoldText
import core.theme.spacing
import core.utils.Horizontal
import home.domain.model.Social
import home.domain.model.SocialMedia
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun SocialButton(
    social: Social,
    maxWidth: Dp = 300.dp,
    onClick: (id: SocialMedia) -> Unit,
) {
    val isAnimating = remember {
        mutableStateOf(false)
    }
    val isAnimated = remember {
        mutableStateOf(false)
    }
    val btnWidth =
        animateDpAsState(
            targetValue = if (isAnimating.value) maxWidth else 20.dp,
            finishedListener = {
                isAnimated.value = isAnimated.value.not()
            },
            animationSpec = tween(
                250, delayMillis = 10, easing = EaseOut
            ), label = ""
        )

    LaunchedEffect(key1 = true) {
        isAnimating.value = true
    }

//    Box(Modifier.padding(1.dp)) {
    NeonShadowBox(
        color = AppColors.NEON2,
        modifier = Modifier.width(
            btnWidth.value
        ).clickable {
            onClick(social.id)
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
            AnimatedVisibility(visible = isAnimated.value) {
                StandardBoldText(
                    text = social.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
//    }
}