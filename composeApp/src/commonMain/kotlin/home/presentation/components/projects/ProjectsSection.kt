package home.presentation.components.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import core.theme.LargeBoldText
import core.theme.spacing
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.projects
import home.domain.model.Project
import org.jetbrains.compose.resources.stringResource


@Composable
fun ProjectsSection(
    onProjectClicked: (project: Project) -> Unit,
    scrollRotation: Float,
    projects: List<Project>,
) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.large)
    ) {
        LargeBoldText(stringResource(Res.string.projects))
        FlowRow(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            maxItemsInEachRow = 3,
        ) {
            projects.forEach {
                ProjectItem(
                    modifier = Modifier
                        .fillMaxWidth(0.325f)
                        .graphicsLayer {
                            this.rotationX = scrollRotation
                            this.rotationZ = scrollRotation / 2
                        },
                    it
                ) {
                    onProjectClicked(it)
                }
            }
        }
    }
}