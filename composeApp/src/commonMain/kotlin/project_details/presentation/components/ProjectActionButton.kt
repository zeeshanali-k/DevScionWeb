package project_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.MediumText
import core.theme.spacing
import core.utils.Horizontal
import core.utils.getOnLinkClickHandler
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectActionButton(
    title: String,
    icon: DrawableResource,
    url: String,
) {
    NeonShadowBox(
        Modifier.clickable {
            getOnLinkClickHandler().onClicked(url)
        },
        color = MaterialTheme.colorScheme.secondary,
    ) {
        Box(
            Modifier.background(MaterialTheme.colorScheme.background)
                .padding(
                    horizontal = MaterialTheme.spacing.small,
                    vertical = 5.dp
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(icon),
                    "",
                    modifier = Modifier.size(70.dp)
                        .clip(CircleShape)
                )
                MaterialTheme.spacing.small.Horizontal()
                MediumText(title)
            }
        }
    }
}