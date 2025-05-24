@file:OptIn(ExperimentalSharedTransitionApi::class)

package home.presentation

import LocalAnimatedContentScope
import LocalSharedTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import core.components.NeonShadowBox
import core.theme.LargeBoldText
import core.theme.LocalWindowSize
import core.theme.WindowSize
import core.theme.spacing
import core.utils.AppConstants
import core.utils.Horizontal
import core.utils.Vertical
import core.utils.getOnLinkClickHandler
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.download_portfolio_app
import devscionweb.composeapp.generated.resources.playstore_icon
import home.domain.model.Project
import home.presentation.components.HomeHeader
import home.presentation.components.TitlesSection
import home.presentation.components.projects.ProjectsSection
import home.presentation.components.skills.SkillsSection
import home.presentation.components.social.SocialSection
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

private const val MAX_Z_TRANSLATION = 3f
private const val HEADER_TILT_TARGET = 7f

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
    onProjectClicked: (project: Project) -> Unit,
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle(HomeState()).value
    val listState = viewModel.listState
    val isCompact = LocalWindowSize.current == WindowSize.COMPACT

    LaunchedEffect(uiState.selectedHomeSection) {
        if (uiState.selectedHomeSection == HomeSection.Top) {
            listState.animateScrollToItem(0)
        } else {
            listState.animateScrollToItem(uiState.selectedHomeSection.index)
        }
    }

    val headerTiltTarget = remember {
        mutableFloatStateOf(0f)
    }
    val headerTilt by animateFloatAsState(
        headerTiltTarget.value, animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioHighBouncy
        )
    )

    LaunchedEffect(Unit) {
        delay(100)
        headerTiltTarget.value = HEADER_TILT_TARGET
    }

    LaunchedEffect(listState.firstVisibleItemIndex) {
        if (listState.isScrollInProgress.not()) {
            viewModel.onSectionSelected(HomeSection.fromIndex(listState.firstVisibleItemIndex))
        }
        if (listState.firstVisibleItemIndex == 0) {
            headerTiltTarget.value = HEADER_TILT_TARGET
        } else {
            headerTiltTarget.value = 0f
        }
    }

    val zTranslationTarget = remember {
        mutableFloatStateOf(0f)
    }
    val xTranslation = animateFloatAsState(
        zTranslationTarget.value,
        animationSpec = spring()
    )

    val scope = rememberCoroutineScope()

    val scrollableState = rememberScrollableState(consumeScrollDelta = {
        scope.launch {
            listState.scrollBy(-it)
            if (it < 2f && it > -2f) {
                zTranslationTarget.value = 0f
            } else {
                zTranslationTarget.value = if (it < 0) -MAX_Z_TRANSLATION else MAX_Z_TRANSLATION
            }
        }
        it
    })

    Box(
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            Modifier.fillMaxSize()
                .scrollable(
                    scrollableState,
                    orientation = Orientation.Vertical,
                )
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.9f))
                .padding(
                    vertical = 20.dp,
                    horizontal = 45.dp
                ),
            state = listState,
            userScrollEnabled = false,
        ) {

            stickyHeader {
                MaterialTheme.spacing.standard.Vertical()
                HomeHeader(
                    Modifier.fillMaxWidth()
                        .graphicsLayer {
                            transformOrigin = TransformOrigin(
                                0.75f,
                                0.5f
                            )
                            rotationZ = headerTilt
                        }
                        .then(with(LocalSharedTransitionScope.current!!) {
                            with(LocalAnimatedContentScope.current!!) {
                                Modifier.renderInSharedTransitionScopeOverlay(
                                    zIndexInOverlay = 1f
                                ).animateEnterExit(
                                    enter = fadeIn(),
                                    exit = fadeOut()
                                )
                            }
                        }),
                    selectedHomeSection = uiState.selectedHomeSection,
                    onSectionSelected = viewModel::onSectionSelected,
                )
            }
            item {
                MaterialTheme.spacing.xLarge.Vertical()

                TitlesSection(Modifier.fillMaxWidth())
            }
            when {
                uiState.isLoading -> item {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                else -> {
                    item {
                        MaterialTheme.spacing.xLarge.Vertical()
                        FlowRow(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalArrangement = Arrangement.spacedBy(
                                MaterialTheme.spacing.standard,
                                alignment = Alignment.Top
                            )
                        ) {

                            SkillsSection(
                                if (isCompact)
                                    Modifier.fillMaxWidth()
                                else Modifier.weight(1f),
                                uiState.skills,
                                xTranslation.value
                            )

                            SocialSection(
                                if (isCompact)
                                    Modifier.fillMaxWidth(1f)
                                else Modifier.weight(1f),
                                uiState.socialData,
                                xTranslation.value
                            )
                        }
                        MaterialTheme.spacing.xLarge.Vertical()
                    }
                    item {
                        ProjectsSection(
                            onProjectClicked = onProjectClicked,
                            xTranslation = xTranslation.value,
                            projects = uiState.projects
                        )
                        MaterialTheme.spacing.xLarge.Vertical()
                        MaterialTheme.spacing.large.Vertical()
                    }
                    item {
                        Box(
                            Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            NeonShadowBox(
                                color = MaterialTheme.colorScheme.secondary,
                            ) {
                                Row(
                                    Modifier.clickable {
                                        getOnLinkClickHandler()
                                            .onClicked(AppConstants.PORTFOLIO_APP)
                                    }.padding(MaterialTheme.spacing.medium),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painterResource(Res.drawable.playstore_icon),
                                        "",
                                        modifier = Modifier.size(70.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    MaterialTheme.spacing.standard.Horizontal()
                                    LargeBoldText(stringResource(Res.string.download_portfolio_app))
                                }
                            }
                        }
                        MaterialTheme.spacing.xLarge.Vertical()
                    }
                }
            }
        }
    }
}