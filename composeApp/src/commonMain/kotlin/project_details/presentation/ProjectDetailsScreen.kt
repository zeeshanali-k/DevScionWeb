@file:OptIn(ExperimentalSharedTransitionApi::class)

package project_details.presentation

import LocalAnimatedContentScope
import LocalSharedTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.components.AnimBackButton
import core.theme.LargeBoldText
import core.theme.StandardText
import core.theme.spacing
import core.utils.Horizontal
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.apple_logo_black
import home.domain.model.Project
import home.domain.model.ProjectLogo
import org.jetbrains.compose.resources.painterResource
import project_details.presentation.components.ProjectActionButton
import project_details.presentation.components.ProjectTechSection

@Composable
fun ProjectDetailsScreen(project: Project, onBackClicked: () -> Unit) {

    val scrollState = rememberScrollState()
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.background)
            .padding(
                vertical = 20.dp,
                horizontal = 40.dp
            )
            .then(with(LocalSharedTransitionScope.current!!) {
                Modifier.sharedBounds(
                    rememberSharedContentState("image_bounds_${project.id}"),
                    LocalAnimatedContentScope.current!!,
                )
            })
    ) {
        MaterialTheme.spacing.standard.Vertical()
        AnimBackButton(onBackClicked)
        MaterialTheme.spacing.large.Vertical()

        Image(
            painter = painterResource(
                ProjectLogo.fromId(project.logo).toDrawableResource()
            ),
            "",
            modifier = Modifier.size(500.dp)
                .then(with(LocalSharedTransitionScope.current!!) {
                    Modifier.sharedElement(
                        rememberSharedContentState("image_${project.id}"),
                        LocalAnimatedContentScope.current!!,
                    )
                })
                .clip(MaterialTheme.shapes.medium)
        )

        //Tech Section
        MaterialTheme.spacing.standard.Vertical()
        ProjectTechSection(project)
        MaterialTheme.spacing.standard.Vertical()
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSecondary
                .copy(alpha = 0.5f),
        )
        MaterialTheme.spacing.large.Vertical()

        //Project Info
        LargeBoldText(
            project.title,
            modifier = Modifier
                .then(with(LocalSharedTransitionScope.current!!) {
                    Modifier.sharedElement(
                        rememberSharedContentState("title_${project.id}"),
                        LocalAnimatedContentScope.current!!,
                    )
                })
        )
        MaterialTheme.spacing.medium.Vertical()
        StandardText(
            project.description,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .then(with(LocalSharedTransitionScope.current!!) {
                    Modifier.sharedElement(
                        rememberSharedContentState("desc_${project.id}"),
                        LocalAnimatedContentScope.current!!,
                    )
                })
        )

        MaterialTheme.spacing.xLarge.Vertical()
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            if (project.isAppStore)
                ProjectActionButton(
                    "Open App Store",
                    Res.drawable.apple_logo_black,
                    project.appStoreLink!!
                )
            MaterialTheme.spacing.xxLarge.Horizontal()

            if (project.isPlaystore)
                ProjectActionButton(
                    "Open Play Store",
                    Res.drawable.android_png_icon,
                    project.link!!
                )
            MaterialTheme.spacing.xxLarge.Horizontal()
            if (project.isPlaystore.not() && project.isAppStore.not() &&
                project.link.isNullOrEmpty().not()
            )
                ProjectActionButton(
                    "View Project",
                    ProjectLogo.fromId(project.logo).toDrawableResource(),
                    project.link,
                )
        }
    }

}