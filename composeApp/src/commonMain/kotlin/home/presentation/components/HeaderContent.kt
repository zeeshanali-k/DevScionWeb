package home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import core.components.NeonShadowBox
import core.theme.spacing
import home.presentation.HomeSection

@Composable
fun HeaderContent(
    modifier: Modifier = Modifier,
    selectedHomeSection: HomeSection,
    onSectionSelected: (HomeSection) -> Unit
) {
    FlowRow(
        modifier.fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .padding(MaterialTheme.spacing.large),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            "@DevScion",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(Modifier.weight(1f))
        remember { HomeSection.values }.forEach {
            SectionItem(it.title, isSelected = selectedHomeSection.index == it.index) {
                onSectionSelected(it)
            }
        }

    }
}

@Composable
fun SectionItem(title: String, isSelected: Boolean, onSectionSelected: () -> Unit) {
    NeonShadowBox(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.xSmall),
        innerModifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onSectionSelected)
            .padding(MaterialTheme.spacing.small),
        backgroundColor =
            if (isSelected) MaterialTheme.colorScheme.secondary
            else MaterialTheme.colorScheme.background,
        color = MaterialTheme.colorScheme.secondary,
    ) {
        Text(
            title, fontSize = 20.sp, color = if (isSelected) MaterialTheme.colorScheme.onBackground
            else MaterialTheme.colorScheme.onSecondary
        )
    }
}