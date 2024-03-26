package home.presentation.components.projects

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.theme.MSmallText
import core.theme.MediumBoldWhiteText
import core.theme.SmallText
import core.theme.spacing
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import home.domain.model.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectItem(project: Project, onItemClicked: () -> Unit) {
    Column(
        Modifier
            .width(180.dp)
            .clickable {
                onItemClicked()
            }
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(
                project.logo
            ),
            contentDescription = "app logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(RoundedCornerShape(10)),
            contentScale = ContentScale.FillBounds,
        )
        MaterialTheme.spacing.standard.Vertical()
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
                .background(MaterialTheme.colors.secondary)
                .padding(MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.Start
        ) {
            MediumBoldWhiteText(
                text = project.title,
                maxLines = 1,
                textAlign = TextAlign.Start
            )
            MaterialTheme.spacing.xSmall.Vertical()
            MSmallText(
                text = project.description,
                maxLines = 2,
                textAlign = TextAlign.Start,
            )
        }
    }
}
