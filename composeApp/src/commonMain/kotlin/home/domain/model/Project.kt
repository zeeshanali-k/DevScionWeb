package home.domain.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi


data class Project @OptIn(ExperimentalResourceApi::class) constructor(
    val id: String,
    val title: String,
    val description: String,
    val isAndroid: Boolean,
    val isHybrid: Boolean,
    val isKMP: Boolean,
    val isPlaystore: Boolean,
    val isAppStore: Boolean,
    val link: String? = null,
    val appStoreLink: String? = null,
    val logo: DrawableResource,
    val languages : List<String>
//    val images: List<ProjectImage>,
)