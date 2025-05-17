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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.components.NeonShadowBox
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
import home.presentation.components.TitlesSection
import home.presentation.components.projects.ProjectsSection
import home.presentation.components.skills.SkillsSection
import home.presentation.components.social.SocialSection
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

//TODO: add Shared Element Transition animation to projects
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel<HomeViewModel>(),
    onProjectClicked: (project: Project) -> Unit,
) {
    val listState = rememberLazyListState()

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
                //TODO: Add Sections Redirect buttons
                MaterialTheme.spacing.standard.Vertical()
                Box(
                    Modifier.fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    NeonShadowBox(
                        Modifier.fillMaxWidth()
                            .graphicsLayer {
                                rotationX = zTranslation.value
                            },
                        radius = 25.dp
                    ) {
                        Row(
                            Modifier.fillMaxWidth()
                                .clip(RoundedCornerShape(25.dp))
                                .padding(MaterialTheme.spacing.large),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                "@DevScion",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }
                }
            }
            item {
                MaterialTheme.spacing.xLarge.Vertical()

                TitlesSection(Modifier.fillMaxWidth())
            }
            item {
                MaterialTheme.spacing.xLarge.Vertical()
                if (MaterialTheme.window == WindowSize.EXPANDED) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        SkillsSection(Modifier.weight(1f))

                        MaterialTheme.spacing.standard.Horizontal()

                        SocialSection(Modifier.weight(1f))
                    }
                } else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        SkillsSection(Modifier.fillMaxWidth())

                        MaterialTheme.spacing.large.Vertical()

                        SocialSection(Modifier.fillMaxWidth())
                    }
                }

                MaterialTheme.spacing.xLarge.Vertical()
            }
            item {
                ProjectsSection(
                    onProjectClicked = onProjectClicked,
                    scrollRotation = zTranslation.value,
                    projects = viewModel.projects.collectAsState().value
                )
                MaterialTheme.spacing.xLarge.Vertical()
                MaterialTheme.spacing.large.Vertical()
            }
            item {
                Box(
                    Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    NeonShadowBox {
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