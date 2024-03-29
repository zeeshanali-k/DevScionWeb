package core.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed
import core.theme.AppColors
import core.theme.fontSize
import core.theme.interFamily
import core.theme.spacing
import core.utils.Horizontal


@Composable
fun AnimBackButton(onBackClicked: () -> Unit) {

    var tSize by remember {
        mutableStateOf(10.dp)
    }
    val size = animateDpAsState(
        targetValue = tSize,
        animationSpec = spring(
            Spring.DampingRatioLowBouncy,
            Spring.StiffnessLow,
        ), label = ""
    )

    LaunchedEffect(true) {
        tSize = 30.dp
    }

    NeonShadowBox(
        color = AppColors.NEON2
    ) {
        Row(
            Modifier
                .clip(RoundedCornerShape(25.dp))
                .clickable {
                    onBackClicked()
                }
                .padding(MaterialTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.AutoMirrored.Rounded.ArrowBack, "",
                tint = MaterialTheme.colors.onSecondary,
                modifier = Modifier.size(size.value)
            )
            MaterialTheme.spacing.standard.Horizontal()
            Typist(
                "Go Back",
                textStyle = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colors.onSecondary,
                    fontSize = MaterialTheme.fontSize.medium
                ),
                isInfinite = false,
                isCursorVisible = false,
                typistSpeed = TypistSpeed.FAST
            )
        }
    }
}