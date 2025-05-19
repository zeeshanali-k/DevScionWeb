package home.presentation

import home.domain.model.Project
import home.domain.model.Social

data class HomeState(
    val projects: List<Project> = emptyList(),
    val socialData: List<Social> = emptyList(),
    val skills: Skills = Skills(),
    val selectedHomeSection: HomeSection = HomeSection.Top,
    val isLoading: Boolean = true,
)

sealed class HomeSection(val index: Int, val title: String) {

    object Top : HomeSection(0, "")
    object SkillsAndSocial : HomeSection(2, "Skills & Social")
    object Projects : HomeSection(3, "Projects")

    companion object {
        val values: List<HomeSection> = listOf(
            SkillsAndSocial, Projects
        )

        fun fromIndex(index: Int) = values.firstOrNull {
            it.index == index
        } ?: run {
            if (index > 3) {
                Projects
            } else {
                Top
            }
        }
    }
}

data class Skills(
    val languages: List<String> = emptyList(),
    val tech: List<String> = emptyList(),
    val other: List<String> = emptyList(),
)