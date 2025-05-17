package core.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HoverableButton() {
    val defaultColor = remember {
        Color.Cyan
    }
    val mInteraction = remember {
        MutableInteractionSource()
    }

    val isHovered = mInteraction.collectIsHoveredAsState().value

    var color1 by remember {
        mutableStateOf(defaultColor)
    }
    var color2 by remember {
        mutableStateOf(defaultColor)
    }

    var color3 by remember {
        mutableStateOf(defaultColor)
    }

    var color4 by remember {
        mutableStateOf(defaultColor)
    }

    var color5 by remember {
        mutableStateOf(defaultColor)
    }

//        var color6 by remember {
//            mutableStateOf(defaultColor)
//        }


    val animColor1 = animateColorAsState(
        color1,
        animationSpec = tween(durationMillis = 500),
    )

    val animColor2 = animateColorAsState(
        color2,
        animationSpec = tween(durationMillis = 500),
    )
    val animColor3 = animateColorAsState(
        color3,
        animationSpec = tween(durationMillis = 500),
    )
    val animColor4 = animateColorAsState(
        color4,
        animationSpec = tween(durationMillis = 500),
    )
    val animColor5 = animateColorAsState(
        color5,
        animationSpec = tween(durationMillis = 500),
    )
//        val animColor6 = animateColorAsState(
//            color6,
//            animationSpec = tween(durationMillis = 500),
//        )

    if (isHovered) {
        color1 = Color(0xFF00C2FF)
        color2 = Color(0xFFFF009D)
        color3 = Color(0xFF9300FF)

        color4 = Color(0xFF5F0FFF)
        color5 = Color(0xFF1904DA)
//            color6 = Color(0xFF8D4BE0)
    } else {
        color1 = defaultColor
        color2 = defaultColor
        color3 = defaultColor
        color4 = defaultColor
        color5 = defaultColor
//            color6 = defaultColor
    }


    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier.hoverable(
                mInteraction
            )
                .clip(RoundedCornerShape(12.dp))
                .shadow(
                    if (isHovered) 10.dp else 1.dp,
                    shape = RoundedCornerShape(12.dp),
                    ambientColor = color1,
                    spotColor = color2
                )
                .background(
                    if (isHovered)
                        Brush.horizontalGradient(
                            colors = listOf(
                                animColor1.value,
                                animColor2.value,
                                animColor3.value,
//                                    animColor4.value,
//                                    animColor5.value,
//                                    animColor6.value,
                            ), startX = -10f,
                            tileMode = TileMode.Decal
                        ) else Brush.linearGradient(colors = listOf(Color.Cyan, Color.Cyan))
                )
                .clickable {
                    //TODO
                }.padding(15.dp),
        ) {
            Text("Click me!", fontSize = 16.sp)
        }

    }
}