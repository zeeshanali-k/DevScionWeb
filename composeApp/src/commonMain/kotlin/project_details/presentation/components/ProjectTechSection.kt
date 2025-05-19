package project_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import core.components.NeonShadowBox
import core.theme.AppColors
import core.theme.MediumText
import core.theme.spacing
import core.utils.Horizontal
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.flutter
import devscionweb.composeapp.generated.resources.kmp
import home.domain.model.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectTechSection(project: Project) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        NeonShadowBox(color = AppColors.NEON3) {
            Box(Modifier.padding(MaterialTheme.spacing.small)) {
                MediumText("Tech")
            }
        }
        MaterialTheme.spacing.standard.Horizontal()
        Image(
            painterResource(
                if (project.isAndroid)
                    Res.drawable.android_png_icon
                else if (project.isKMP)
                    Res.drawable.kmp
                else if (project.isHybrid)
                    Res.drawable.flutter
                else Res.drawable.android_png_icon
            ),
            contentDescription = "app logo",
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .size(70.dp),
//                .aspectRatio(8f / 3f),
            contentScale = ContentScale.Fit,
        )
        MaterialTheme.spacing.standard.Horizontal()
        LazyRow(Modifier.fillMaxWidth()) {
            items(project.languages) {
                Row {
                    Box(
                        Modifier.border(
                            1.dp, MaterialTheme.colorScheme.onSecondary.copy(0.5f),
                            shape = RoundedCornerShape(10.dp)
                        )
                            .padding(MaterialTheme.spacing.small),
                        contentAlignment = Alignment.Center
                    ) {
                        MediumText(it)
                    }
                    MaterialTheme.spacing.medium.Horizontal()
                }
            }
        }
    }
}