package home.domain.model

import core.domain.model.JavaSerializable
import kotlinx.serialization.Serializable

@Serializable
data class Project(
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
    val logo: ProjectLogo,
    val languages: List<String>
//    val images: List<ProjectImage>,
) : JavaSerializable