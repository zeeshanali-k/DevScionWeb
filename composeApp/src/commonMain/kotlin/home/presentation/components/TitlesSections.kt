package home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.WindowSize
import core.theme.fontSize
import core.theme.spacing
import core.theme.window
import core.utils.Horizontal
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.kmp
import devscionweb.composeapp.generated.resources.my_img
import devscionweb.composeapp.generated.resources.name
import home.domain.model.TechnicalSkill
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

private const val TARGET_IMAGE_SIZE = 200f

@Composable
fun TitlesSection(modifier: Modifier = Modifier) {
    var tImgSize by remember {
        mutableStateOf(30.dp)
    }

    val imgSize = animateDpAsState(
        targetValue = tImgSize,
        animationSpec = spring(
            Spring.DampingRatioLowBouncy,
            Spring.StiffnessLow,
        ), label = ""
    )

    LaunchedEffect(true) {
        tImgSize = TARGET_IMAGE_SIZE.dp
    }

    var currentImage by remember {
        mutableStateOf<TechnicalSkill>(TechnicalSkill.Android)
    }

    val windowSize = MaterialTheme.window

    if (windowSize == WindowSize.EXPANDED) {
        DesktopView(modifier, imgSize.value, currentImage, onAnimationEnd = {
            currentImage = if (currentImage == TechnicalSkill.Android)
                TechnicalSkill.KMP
            else TechnicalSkill.Android
        })
    } else {
        MobileView(modifier, imgSize.value, currentImage, onAnimationEnd = {
            currentImage = if (currentImage == TechnicalSkill.Android)
                TechnicalSkill.KMP
            else TechnicalSkill.Android
        })

    }

}

@Composable
fun MobileView(
    modifier: Modifier,
    imgSize: Dp,
    currentImage: TechnicalSkill,
    onAnimationEnd: () -> Unit,
) {
    Column(
        modifier
            .padding(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ImageNameSection(imgSize)
        MaterialTheme.spacing.standard.Vertical()
        Typist(
            remember { listOf(TechnicalSkill.Android.title, TechnicalSkill.KMP.title) },
            textStyle = TextStyle(
                fontSize = MaterialTheme.fontSize.xLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            ),
            typistSpeed = TypistSpeed.FAST,
            isInfinite = true,
            isCursorVisible = true,
            isBlinkingCursor = false,
            cursorColor = AppColors.NEON,
            onAnimationEnd = onAnimationEnd
        )

        MaterialTheme.spacing.large.Vertical()
        NeonShadowBox {
            Column(
                Modifier
                    .height(200.dp)
                    .padding(horizontal = MaterialTheme.spacing.standard),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    currentImage == TechnicalSkill.KMP,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.kmp),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
                AnimatedVisibility(
                    currentImage == TechnicalSkill.Android,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.android_png_icon),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageNameSection(imgSize: Dp) {
    NeonShadowBox(
        innerModifier = Modifier.padding(MaterialTheme.spacing.standard)
    ) {
        Column(
            Modifier
                .widthIn(min = TARGET_IMAGE_SIZE.dp)
                .heightIn(min = TARGET_IMAGE_SIZE.dp)
                .animateContentSize(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(Res.drawable.my_img),
                contentDescription = "portfolio image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imgSize)
                    .clip(CircleShape)
            )
            if (imgSize.value == TARGET_IMAGE_SIZE) {
                Typist(
                    stringResource(Res.string.name),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = MaterialTheme.fontSize.standard
                    ),
                    isInfiniteCursor = false,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}


@Composable
fun DesktopView(
    modifier: Modifier,
    imgSize: Dp,
    currentImage: TechnicalSkill,
    onAnimationEnd: () -> Unit,
) {
    Row(
        modifier
            .padding(MaterialTheme.spacing.large),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageNameSection(imgSize)
        MaterialTheme.spacing.large.Horizontal()
        Typist(
            remember { listOf(TechnicalSkill.Android.title, TechnicalSkill.KMP.title) },
            textStyle = TextStyle(
                fontSize = MaterialTheme.fontSize.xLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start
            ),
            typistSpeed = TypistSpeed.FAST,
            isInfinite = true,
            isCursorVisible = true,
            isBlinkingCursor = false,
            cursorColor = AppColors.NEON,
            modifier = Modifier.fillMaxWidth(0.35f),
            onAnimationEnd = onAnimationEnd
        )

        MaterialTheme.spacing.large.Horizontal()
        NeonShadowBox {
            Column(
                Modifier
                    .size(200.dp)
                    .padding(horizontal = MaterialTheme.spacing.standard),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    currentImage == TechnicalSkill.KMP,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.kmp),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
                AnimatedVisibility(
                    currentImage == TechnicalSkill.Android,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.android_png_icon),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
            }
        }
    }
}
