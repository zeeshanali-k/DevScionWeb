package home.domain.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi


data class Social @OptIn(ExperimentalResourceApi::class) constructor(
    val id: SocialMedia,
    val title: String,
    val icon: DrawableResource,
    val link: String
)


enum class SocialMedia {
    LINKEDIN, MEDIUM, GITHUB, GMAIL, YOUTUBE, STACK_OVERFLOW
}