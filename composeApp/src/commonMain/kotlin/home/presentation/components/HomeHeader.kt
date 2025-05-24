package home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.components.TranslucentNeonShadowBox
import home.presentation.HomeSection

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    selectedHomeSection: HomeSection,
    onSectionSelected: (HomeSection) -> Unit,
) {
    TranslucentNeonShadowBox(
        modifier = modifier,
        radius = 25.dp
    ) {
        HeaderContent(
            modifier = Modifier.fillMaxWidth(),
            selectedHomeSection = selectedHomeSection,
            onSectionSelected = onSectionSelected
        )
    }
}