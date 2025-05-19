package core.utils

import kotlinx.serialization.Serializable

@Serializable
object ScreenHome

@Serializable
data class ScreenProject(val projectId: String)