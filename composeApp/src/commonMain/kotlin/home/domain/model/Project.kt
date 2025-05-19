package home.domain.model

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
    val logo: Int,
    val languages: List<String>
//    val images: List<ProjectImage>,
)