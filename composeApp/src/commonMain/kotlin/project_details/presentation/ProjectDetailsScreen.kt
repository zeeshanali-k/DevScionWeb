@file:OptIn(ExperimentalSharedTransitionApi::class)

package project_details.presentation

import LocalAnimatedContentScope
import LocalSharedTransitionScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateDp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.materialkolor.ktx.rememberThemeColor
import core.components.AnimBackButton
import core.theme.LargeBoldText
import core.theme.StandardText
import core.theme.spacing
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.apple_logo_black
import home.domain.model.Project
import home.domain.model.ProjectLogo
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import project_details.presentation.components.ProjectActionButton
import project_details.presentation.components.ProjectTechSection

@Composable
fun ProjectDetailsScreen(project: Project, onBackClicked: () -> Unit) {

    val scrollState = rememberScrollState()
    val sharedTransitionScope = LocalSharedTransitionScope.current!!
    val animatedVisibilityScope = LocalAnimatedContentScope.current!!

    val boundsCornerSize = animatedVisibilityScope.transition.animateDp { enterExit ->
        when (enterExit) {
            EnterExitState.PreEnter -> 6.dp
            EnterExitState.Visible -> 0.dp
            EnterExitState.PostExit -> 0.dp
        }
    }
    val imageCornerSize = animatedVisibilityScope.transition.animateDp { enterExit ->
        when (enterExit) {
            EnterExitState.PreEnter -> 6.dp
            EnterExitState.Visible -> 12.dp
            EnterExitState.PostExit -> 12.dp
        }
    }
    val img = imageResource(ProjectLogo.fromId(project.logo).toDrawableResource())
    val bgColor = rememberThemeColor(img)
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(scrollState).background(
                Brush.verticalGradient(
                    colors = listOf(
                        bgColor.copy(0.5f),
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.background,
                    )
                )
            )
            .padding(
                vertical = MaterialTheme.spacing.medium,
                horizontal = MaterialTheme.spacing.mLarge
            )
    ) {
        MaterialTheme.spacing.standard.Vertical()
        AnimBackButton(
            onBackClicked = onBackClicked,
        )
        MaterialTheme.spacing.large.Vertical()
        Column(
            Modifier.fillMaxWidth()
                .then(with(sharedTransitionScope) {
                    Modifier.sharedBounds(
                        rememberSharedContentState("bounds_${project.id}"),
                        animatedVisibilityScope,
                        clipInOverlayDuringTransition = OverlayClip(
                            clipShape = RoundedCornerShape(boundsCornerSize.value)
                        )
                    )
                }),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(
                    ProjectLogo.fromId(project.logo).toDrawableResource()
                ),
                "",
                modifier = Modifier.size(500.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .then(with(sharedTransitionScope) {
                        Modifier.sharedElement(
                            rememberSharedContentState("image_${project.id}"),
                            animatedVisibilityScope,
                            clipInOverlayDuringTransition = OverlayClip(
                                clipShape = RoundedCornerShape(imageCornerSize.value)
                            )
                        )
                    })
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
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .then(with(sharedTransitionScope) {
                        Modifier.sharedElement(
                            rememberSharedContentState("title_${project.id}"),
                            animatedVisibilityScope,
                        ).skipToLookaheadSize()
                    })
            )
            MaterialTheme.spacing.medium.Vertical()
            StandardText(
                project.description,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .then(with(sharedTransitionScope) {
                        Modifier.sharedElement(
                            rememberSharedContentState("desc_${project.id}"),
                            animatedVisibilityScope,
                        ).skipToLookaheadSize()
                    })
            )
        }
        MaterialTheme.spacing.largeMax1.Vertical()
        FlowRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.xxLarge,
                alignment = Alignment.CenterHorizontally
            ),
        ) {
            if (project.isAppStore)
                ProjectActionButton(
                    "Open App Store",
                    Res.drawable.apple_logo_black,
                    project.appStoreLink!!
                )

            if (project.isPlaystore)
                ProjectActionButton(
                    "Open Play Store",
                    Res.drawable.android_png_icon,
                    project.link!!
                )
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