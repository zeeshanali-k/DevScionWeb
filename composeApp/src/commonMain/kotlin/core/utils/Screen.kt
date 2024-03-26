package core.utils

import home.domain.model.Project


sealed interface Screen {
     data object Home : Screen
    data class ProjectDetails(val project: Project) : Screen
}