package home.presentation.components.projects

import LocalAnimatedContentScope
import LocalSharedTransitionScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.animateDp
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
    val sharedTransitionScope = LocalSharedTransitionScope.current!!
    val animatedVisibilityScope = LocalAnimatedContentScope.current!!
    val cornerSize = animatedVisibilityScope.transition.animateDp { enterExit ->
        when (enterExit) {
            EnterExitState.PreEnter -> 0.dp
            EnterExitState.Visible -> 6.dp
            EnterExitState.PostExit -> 6.dp
        }
    }
    val imageCornerSize = animatedVisibilityScope.transition.animateDp { enterExit ->
        when (enterExit) {
            EnterExitState.PreEnter -> 12.dp
            EnterExitState.Visible -> 6.dp
            EnterExitState.PostExit -> 6.dp
        }
    }
    NeonShadowBox(
        modifier = modifier
            .clickable {
                onItemClicked()
            }
            .padding(MaterialTheme.spacing.xSmall)
            .then(with(sharedTransitionScope) {
                Modifier.sharedBounds(
                    rememberSharedContentState("bounds_${project.id}"),
                    animatedVisibilityScope,
                    resizeMode = SharedTransitionScope.ResizeMode.RemeasureToBounds,
                    clipInOverlayDuringTransition = OverlayClip(
                        clipShape = RoundedCornerShape(cornerSize.value)
                    )
                )
            }),
        color = MaterialTheme.colorScheme.secondary
    ) {
        Column(
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
                    .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                    .then(with(sharedTransitionScope) {
                        Modifier.sharedElement(
                            rememberSharedContentState("image_${project.id}"),
                            animatedVisibilityScope,
                            clipInOverlayDuringTransition = OverlayClip(
                                clipShape = RoundedCornerShape(
                                    topStart = imageCornerSize.value,
                                    topEnd = imageCornerSize.value
                                )
                            )
                        )
                    }),
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
                        .then(with(sharedTransitionScope) {
                            Modifier.sharedElement(
                                rememberSharedContentState("title_${project.id}"),
                                animatedVisibilityScope,
                            )
                        })
                )
                MaterialTheme.spacing.xSmall.Vertical()
                MSmallText(
                    text = project.description,
                    maxLines = 2,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .then(with(sharedTransitionScope) {
                            Modifier.sharedElement(
                                rememberSharedContentState("desc_${project.id}"),
                                animatedVisibilityScope,
                            )
                        })
                )
            }
        }
    }
}
