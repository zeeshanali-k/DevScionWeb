package home.presentation.components.social

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import core.theme.StandardBoldText
import home.domain.model.Social
import home.domain.model.SocialMedia
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun SocialButton(
    social: Social,
    maxWidth: Dp = 110.dp,
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
    Button(
        onClick = { onClick(social.id) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary
        ), modifier = Modifier.width(
            btnWidth.value
        )
    ) {
        Row {
            Image(
                painter = painterResource(social.icon),
                contentDescription = "linkedin",
                Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
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