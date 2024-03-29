@file:OptIn(ExperimentalResourceApi::class)

package home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.LargeBoldText
import core.theme.WindowSize
import core.theme.spacing
import core.theme.window
import core.utils.AppConstants
import core.utils.Horizontal
import core.utils.Vertical
import core.utils.getOnLinkClickHandler
import devscionweb.composeapp.generated.resources.Res
import home.domain.model.Project
import home.presentation.components.TitlesSection
import home.presentation.components.projects.ProjectsSection
import home.presentation.components.skills.SkillsSection
import home.presentation.components.social.SocialSection
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun HomeScreen(
    onProjectClicked: (project: Project) -> Unit
) {

    val listState = rememberLazyListState()
//    val density = LocalDensity.current


    Box(Modifier.fillMaxSize()) {
        Box(Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .drawBehind {
                drawCircle(
                    color = AppColors.NEON,
                    radius = 250.0f,
                    center = Offset(
                        this.size.width * 0.05f,
                        this.size.height * 0.1f
                        //- (listState.firstVisibleItemScrollOffset / 3 * density.density)
                    )
                )
                drawCircle(
                    color = AppColors.NEON3,
                    radius = 250.0f,
                    center = Offset(
                        this.size.width,
                        this.size.height
                        //- (listState.firstVisibleItemScrollOffset / 3 * density.density)
                    )
                )
            })
        LazyColumn(
            Modifier.fillMaxSize()
                .background(MaterialTheme.colors.background.copy(alpha = 0.9f))
                .padding(
                    vertical = 20.dp,
                    horizontal = 45.dp
                ),
            state = listState
        ) {

            item {
                MaterialTheme.spacing.standard.Vertical()
                NeonShadowBox(
                    Modifier.fillMaxWidth(), radius = 25.dp
                ) {
                    Row(
                        Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(25.dp))
//                        .background(
//                            Brush.horizontalGradient(
//                                listOf(
//                                    Color(0xFFE24462).copy(
//                                        alpha = 0.3f
//                                    ), Color(0xFFB125EA).copy(
//                                        alpha = 0.3f
//                                    ), Color(0xFF7F52FF).copy(
//                                        alpha = 0.3f
//                                    )
//                                )
//                            )
//                        )
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
                ProjectsSection(onProjectClicked = onProjectClicked)
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