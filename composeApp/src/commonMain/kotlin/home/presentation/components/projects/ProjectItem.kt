package home.presentation.components.projects

import LocalAnimatedContentScope
import LocalSharedTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.MSmallText
import core.theme.MediumBoldWhiteText
import core.theme.spacing
import core.utils.Vertical
import home.domain.model.Project
import home.domain.model.ProjectLogo
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalResourceApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun ProjectItem(modifier: Modifier = Modifier, project: Project, onItemClicked: () -> Unit) {
    val density = LocalDensity.current
    NeonShadowBox(
        modifier = modifier
            .clickable {
                onItemClicked()
            }
            .padding(MaterialTheme.spacing.xSmall),
        color = MaterialTheme.colorScheme.secondary
    ) {
        Column(
            modifier = with(LocalSharedTransitionScope.current!!) {
                Modifier.sharedBounds(
                    rememberSharedContentState("image_bounds_${project.id}"),
                    LocalAnimatedContentScope.current!!,
                )
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(
                    ProjectLogo.fromId(project.logo).toDrawableResource()
                ),
                contentDescription = "app logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(density) {
                        280.dp
                    })
                    .then(with(LocalSharedTransitionScope.current!!) {
                        Modifier.sharedElement(
                            rememberSharedContentState("image_${project.id}"),
                            LocalAnimatedContentScope.current!!,
                        )
                    })
                    .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)),
                contentScale = ContentScale.FillBounds,
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp))
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(MaterialTheme.spacing.medium),
                horizontalAlignment = Alignment.Start
            ) {
                MediumBoldWhiteText(
                    text = project.title,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .then(with(LocalSharedTransitionScope.current!!) {
                            Modifier.sharedElement(
                                rememberSharedContentState("title_${project.id}"),
                                LocalAnimatedContentScope.current!!,
                            )
                        })
                )
                MaterialTheme.spacing.xSmall.Vertical()
                MSmallText(
                    text = project.description,
                    maxLines = 2,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .then(with(LocalSharedTransitionScope.current!!) {
                            Modifier.sharedElement(
                                rememberSharedContentState("desc_${project.id}"),
                                LocalAnimatedContentScope.current!!,
                            )
                        })
                )
            }
        }
    }
}
