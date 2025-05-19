package home.presentation.components.skills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.MediumBoldWhiteText
import core.theme.spacing
import core.utils.Horizontal


@Composable
fun SkillsRow(modifier: Modifier = Modifier, skills: List<String>) {
    FlowRow(
        modifier.fillMaxWidth()
            .padding(start = MaterialTheme.spacing.standard),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard)
    ) {
        skills.forEach {
            SkillItem(skill = it)
            MaterialTheme.spacing.standard.Horizontal()
        }
    }
}

@Composable
fun SkillItem(skill: String) {
    NeonShadowBox(
        color = AppColors.NEON3
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(15.dp))
                .padding(
                    MaterialTheme.spacing.medium
                )
        ) {
            MediumBoldWhiteText(
                text = skill,
            )
        }
    }
}