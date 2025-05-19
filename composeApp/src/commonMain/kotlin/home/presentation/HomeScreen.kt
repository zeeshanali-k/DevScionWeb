package home.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import core.components.NeonShadowBox
import core.components.TranslucentNeonShadowBox
import core.theme.LargeBoldText
import core.theme.WindowSize
import core.theme.spacing
import core.theme.window
import core.utils.AppConstants
import core.utils.Horizontal
import core.utils.Vertical
import core.utils.getOnLinkClickHandler
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.playstore_icon
import home.domain.model.Project
import home.presentation.components.HeaderContent
import home.presentation.components.TitlesSection
import home.presentation.components.projects.ProjectsSection
import home.presentation.components.skills.SkillsSection
import home.presentation.components.social.SocialSection
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
    onProjectClicked: (project: Project) -> Unit,
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle(HomeState()).value
    val listState = rememberLazyListState()

    LaunchedEffect(uiState.selectedHomeSection) {
        if (uiState.selectedHomeSection == HomeSection.Top) {
            listState.animateScrollToItem(0)
        } else {
            listState.animateScrollToItem(uiState.selectedHomeSection.index)
        }
    }

    LaunchedEffect(listState.firstVisibleItemIndex) {
        if (listState.isScrollInProgress.not()) {
            viewModel.onSectionSelected(HomeSection.fromIndex(listState.firstVisibleItemIndex))
        }
    }

    val zTranslationTarget = remember {
        mutableStateOf(0f)
    }
    val zTranslation = animateFloatAsState(
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
                zTranslationTarget.value = if (it < 0) -2.5f else 2.5f
            }
        }
        it
    })

    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        )
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
                TranslucentNeonShadowBox(
                    Modifier.fillMaxWidth()
                        .graphicsLayer {
                            rotationX = zTranslation.value / 2
                        },
                    radius = 25.dp
                ) {
                    HeaderContent(
                        modifier = Modifier.fillMaxWidth(),
                        selectedHomeSection = uiState.selectedHomeSection,
                        onSectionSelected = viewModel::onSectionSelected
                    )
                }
            }
            item {
                MaterialTheme.spacing.xLarge.Vertical()

                TitlesSection(Modifier.fillMaxWidth())
            }
            if (uiState.isLoading) {
                item {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            } else {
                item {
                    MaterialTheme.spacing.xLarge.Vertical()
                    if (MaterialTheme.window == WindowSize.EXPANDED) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            SkillsSection(Modifier.weight(1f), uiState.skills)

                            MaterialTheme.spacing.standard.Horizontal()

                            SocialSection(Modifier.weight(1f), uiState.socialData)
                        }
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            SkillsSection(Modifier.fillMaxWidth(), uiState.skills)

                            MaterialTheme.spacing.large.Vertical()

                            SocialSection(Modifier.fillMaxWidth(), uiState.socialData)
                        }
                    }

                    MaterialTheme.spacing.xLarge.Vertical()
                }
                item {
                    ProjectsSection(
                        onProjectClicked = onProjectClicked,
                        scrollRotation = zTranslation.value,
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
                                LargeBoldText("Download Portfolio App")
                            }
                        }
                    }
                    MaterialTheme.spacing.xLarge.Vertical()
                }
            }
        }
    }
}