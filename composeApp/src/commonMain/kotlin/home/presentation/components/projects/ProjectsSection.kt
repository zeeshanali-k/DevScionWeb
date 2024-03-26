package home.presentation.components.projects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.theme.LargeBoldText
import core.theme.spacing
import core.utils.AppConstants
import core.utils.Horizontal
import core.utils.Vertical
import home.domain.model.Project
import home.presentation.components.projects.ProjectItem


@Composable
fun ProjectsSection(onProjectClicked: (project: Project) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        LargeBoldText("Projects")
        MaterialTheme.spacing.large.Vertical()
        LazyRow(
            Modifier.fillMaxWidth()
        ) {
            items(AppConstants.getAllProjects()) {
                MaterialTheme.spacing.large.Horizontal()
                ProjectItem(
                    it
                ) {
                    onProjectClicked(it)
                }
            }

        }
    }
}