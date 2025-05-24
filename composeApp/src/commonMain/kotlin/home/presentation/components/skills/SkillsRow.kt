package home.presentation.components.skills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.MediumBoldWhiteText
import core.theme.spacing


@Composable
fun SkillsRow(modifier: Modifier = Modifier, skills: List<String>, xTranslation: Float) {
    FlowRow(
        modifier.fillMaxWidth()
            .padding(start = MaterialTheme.spacing.standard),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard)
    ) {
        skills.forEach {
            SkillItem(skill = it, modifier = modifier.graphicsLayer {
                rotationX = xTranslation
            })
        }
    }
}

@Composable
fun SkillItem(modifier: Modifier = Modifier, skill: String) {
    NeonShadowBox(
        modifier = modifier,
        color = AppColors.NEON3,
        innerModifier = Modifier
            .padding(
                MaterialTheme.spacing.medium
            )
    ) {
        MediumBoldWhiteText(
            text = skill,
        )
    }

}