package home.presentation.components.skills

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.theme.StandardBoldText
import core.theme.spacing
import core.utils.AppConstants
import core.utils.Vertical


@Composable
fun SkillsSection() {

    Column(Modifier.fillMaxWidth()) {
        StandardBoldText(
            text = "Languages",
        )

        MaterialTheme.spacing.small.Vertical()
        SkillsRow(skills = AppConstants.LANGUAGES)

        MaterialTheme.spacing.standard.Vertical()

        StandardBoldText(
            text = "Technologies",
        )

        MaterialTheme.spacing.small.Vertical()
        SkillsRow(skills = AppConstants.TECH)
        MaterialTheme.spacing.standard.Vertical()

        StandardBoldText(
            text = "Architecture",
        )
        MaterialTheme.spacing.small.Vertical()
        SkillsRow(skills = AppConstants.OTHER)
    }
}