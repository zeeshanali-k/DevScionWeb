package home.presentation

import androidx.lifecycle.ViewModel
import core.utils.AppConstants
import home.domain.model.Project
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    private val _projects = MutableStateFlow(emptyList<Project>())
    val projects = _projects.asStateFlow()


    init {
        _projects.value = AppConstants.getAllProjects()
    }

}