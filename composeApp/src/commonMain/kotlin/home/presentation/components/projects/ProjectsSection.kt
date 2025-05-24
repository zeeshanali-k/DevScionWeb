package home.presentation.components.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import core.theme.LargeBoldText
import core.theme.WindowSize
import core.theme.spacing
import core.theme.window
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.projects
import home.domain.model.Project
import org.jetbrains.compose.resources.stringResource

@Composable
fun ProjectsSection(
    onProjectClicked: (project: Project) -> Unit,
    xTranslation: Float,
    projects: List<Project>,
) {
    val density = LocalDensity.current
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large)
    ) {
        LargeBoldText(stringResource(Res.string.projects))
        FlowRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = if (MaterialTheme.window == WindowSize.COMPACT) Arrangement.spacedBy(
                MaterialTheme.spacing.standard,
                Alignment.CenterHorizontally
            ) else Arrangement.spacedBy(
                MaterialTheme.spacing.standard,
                Alignment.Start
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large)
        ) {
            projects.forEach {
                ProjectItem(
                    modifier = Modifier
                        .width(with(density) {
                            300.dp
                        })
                        .graphicsLayer {
                            this.rotationX = xTranslation
                        },
                    it
                ) {
                    onProjectClicked(it)
                }
            }
        }
    }
}