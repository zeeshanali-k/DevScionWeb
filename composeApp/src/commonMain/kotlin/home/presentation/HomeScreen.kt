package home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.components.NeonShadowBox
import core.components.WrapperCard
import core.theme.spacing
import core.utils.Horizontal
import core.utils.Vertical
import home.domain.model.Project
import home.presentation.components.TitlesSection
import home.presentation.components.projects.ProjectsSection
import home.presentation.components.skills.SkillsSection
import home.presentation.components.social.SocialSection


@Composable
fun HomeScreen(
    onProjectClicked: (project: Project) -> Unit
) {
    val homeScrollState = rememberScrollState()
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(homeScrollState)
            .background(MaterialTheme.colors.background)
            .padding(
                vertical = 20.dp,
                horizontal = 45.dp
            )
    ) {

        MaterialTheme.spacing.standard.Vertical()

        NeonShadowBox(Modifier.fillMaxWidth(), radius = 25.dp) {
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

        MaterialTheme.spacing.xLarge.Vertical()

        TitlesSection()

        MaterialTheme.spacing.xLarge.Vertical()
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            WrapperCard(
                modifier = Modifier.weight(1f),
                title = "Skills",
                description = "Languages, Tech and Architecture I use in my projects",
                content = { SkillsSection() }
            )

            MaterialTheme.spacing.standard.Horizontal()

            WrapperCard(
                modifier = Modifier.weight(1f),
                title = "Social",
                description = "Connect with me on Social Platforms",
                content = { SocialSection() }
            )
        }

        MaterialTheme.spacing.xLarge.Vertical()
        ProjectsSection(onProjectClicked = onProjectClicked)
    }
}