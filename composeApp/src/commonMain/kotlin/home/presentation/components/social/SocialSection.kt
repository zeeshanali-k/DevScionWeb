package home.presentation.components.social

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import core.theme.spacing
import core.utils.getOnLinkClickHandler
import home.domain.model.Social


@Composable
fun SocialSection(modifier: Modifier = Modifier, socialData: List<Social>, xRotation: Float) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.standard,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
        maxItemsInEachRow = 2,
    ) {
        socialData.forEach {
            SocialButton(
                modifier = Modifier.graphicsLayer { rotationX = xRotation },
                social = it,
                onClick = {
                    getOnLinkClickHandler().onClicked(it.link)
                })
        }
    }

}