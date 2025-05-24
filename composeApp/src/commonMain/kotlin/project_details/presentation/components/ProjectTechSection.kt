package project_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.flutter
import devscionweb.composeapp.generated.resources.kmp
import devscionweb.composeapp.generated.resources.tech
import home.domain.model.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProjectTechSection(project: Project) {
    FlowRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.standard,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.Center
    ) {
        NeonShadowBox(
            color = AppColors.NEON3,
            innerModifier = Modifier.padding(MaterialTheme.spacing.small)
        ) {
            MediumText(stringResource(Res.string.tech))
        }
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
            contentScale = ContentScale.Fit,
        )
        project.tech.forEach {
            MediumText(
                it,
                modifier =
                    Modifier.border(
                        1.dp, MaterialTheme.colorScheme.onSecondary.copy(0.5f),
                        shape = RoundedCornerShape(10.dp)
                    )
                        .padding(MaterialTheme.spacing.small),
            )
        }
    }
}