package home.presentation

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.ViewModel
import core.utils.AppConstants
import home.domain.model.Project
import home.domain.model.Social
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class HomeViewModel : ViewModel() {

    val listState = LazyListState()

    private val projects = MutableStateFlow(emptyList<Project>())

    private val skills = MutableStateFlow(Skills())

    private val socialData = MutableStateFlow(emptyList<Social>())

    private val selectedHomeSection = MutableStateFlow<HomeSection>(HomeSection.Top)

    private val isLoading = MutableStateFlow(true)

    val uiState =
        combine(
            projects,
            skills,
            socialData,
            selectedHomeSection,
            isLoading,
        ) { projects, skills, socialData, selectedHomeSection, loading ->
            HomeState(
                projects = projects,
                skills = skills,
                socialData = socialData,
                selectedHomeSection = selectedHomeSection,
                isLoading = loading
            )
        }

    init {
        projects.value = AppConstants.getAllProjects()
        skills.value = Skills(
            AppConstants.LANGUAGES,
            AppConstants.TECH,
            AppConstants.OTHER
        )
        socialData.value = AppConstants.SocialData
        isLoading.value = false
    }

    fun onSectionSelected(section: HomeSection) {
        selectedHomeSection.value = section
    }

}