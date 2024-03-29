@file:OptIn(ExperimentalResourceApi::class)

package home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
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
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


val SKILLS = listOf(
    "Android Developer",
    "Flutter Developer"
)

@OptIn(ExperimentalResourceApi::class)
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
        tImgSize = 200.dp
    }

    var currentImage by remember {
        mutableStateOf<SkillImage>(SkillImage.Android)
    }

    val windowSize = MaterialTheme.window

    LaunchedEffect(true) {
        while (true) {
            delay(
                currentImage.title.length.toLong() * (TypistSpeed.FAST.value + 5)
            )
            currentImage = if (currentImage == SkillImage.Android)
                SkillImage.Flutter
            else SkillImage.Android
        }
    }

    if (windowSize == WindowSize.EXPANDED) {
        DesktopView(modifier,imgSize, currentImage)
    } else {
        MobileView(modifier,imgSize, currentImage)

    }

}

@Composable
fun MobileView(modifier: Modifier, imgSize: State<Dp>, currentImage: SkillImage) {
    Column(
        modifier
            .padding(MaterialTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(Res.drawable.my_img),
            contentDescription = "portfolio image",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(imgSize.value)
                .clip(RoundedCornerShape(50))
        )
        MaterialTheme.spacing.standard.Vertical()
        Typist(
            SKILLS,
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
                    currentImage == SkillImage.Flutter,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.flutter),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
                AnimatedVisibility(
                    currentImage == SkillImage.Android,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
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
fun DesktopView(modifier: Modifier, imgSize: State<Dp>, currentImage: SkillImage) {
    Row(
        modifier
            .padding(MaterialTheme.spacing.large),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.my_img),
            contentDescription = "portfolio image",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(imgSize.value)
                .clip(RoundedCornerShape(50))
        )
        MaterialTheme.spacing.standard.Horizontal()
        Typist(
            SKILLS,
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
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        MaterialTheme.spacing.large.Horizontal()
        NeonShadowBox {
            Column(
                Modifier
                    .height(200.dp)
                    .padding(horizontal = MaterialTheme.spacing.standard),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    currentImage == SkillImage.Flutter,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    Image(
                        painter = painterResource(Res.drawable.flutter),
                        contentDescription = "",
                        modifier = Modifier.size(200.dp)
                    )
                }
                AnimatedVisibility(
                    currentImage == SkillImage.Android,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
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

sealed class SkillImage(val title: String) {
    data object Android : SkillImage("Android Developer")
    data object Flutter : SkillImage("Flutter Developer")
}