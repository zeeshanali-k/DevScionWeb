package core.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.theme.AppColors.CardGradient
import core.theme.LargeBoldText
import core.theme.StandardBoldText
import core.theme.StandardText


@Composable
fun WrapperCard(
    modifier: Modifier = Modifier,
    title: String, description: String,
    content: (@Composable () -> Unit)? = null,
    onClickListener: (() -> Unit)? = null
) {
    val isHidden = remember {
        mutableStateOf(true)
    }

    val iconRotation = animateFloatAsState(
        targetValue = if (isHidden.value) 0f else 180f,
        label = ""
    )

    Card(
        shape = RoundedCornerShape(15.dp), elevation = 2.dp,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(CardGradient)
                .padding(vertical = 15.dp, horizontal = 10.dp)
        ) {
            LargeBoldText(text = title)
            Spacer(modifier = Modifier.height(10.dp))
            StandardText(text = description)
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                Modifier
                    .background(Color.Black.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .clickable {
                        if (content != null)
                            isHidden.value = isHidden.value.not()
                        if (onClickListener != null) {
                            onClickListener()
                        }
                    }
                    .padding(10.dp)
                    .animateContentSize(
                        spring(
                            Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StandardBoldText(
                        text = if (isHidden.value) "View"
                        else "Hide",
                    )
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        tint = Color.White,
                        modifier = Modifier.rotate(
                            if (content != null)
                                iconRotation.value
                            else -90f
                        ),
                        contentDescription = "expand"
                    )
                }
                if (isHidden.value.not() && content != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    content()
                }
            }
        }
    }
}