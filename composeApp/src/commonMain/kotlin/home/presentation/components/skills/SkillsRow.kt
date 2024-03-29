package home.presentation.components.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.MediumBoldWhiteText
import core.theme.spacing
import core.utils.Horizontal


@Composable
fun SkillsRow(skills: List<String>) {
    LazyRow {
        item {
            MaterialTheme.spacing.standard.Horizontal()
        }
        items(skills) {
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