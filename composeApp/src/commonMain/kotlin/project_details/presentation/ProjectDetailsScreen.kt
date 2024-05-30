package project_details.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import core.components.AnimBackButton
import core.theme.LargeBoldText
import core.theme.StandardText
import core.theme.spacing
import core.utils.Horizontal
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.android_png_icon
import devscionweb.composeapp.generated.resources.apple_logo_black
import home.domain.model.Project
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import project_details.presentation.components.ProjectActionButton
import project_details.presentation.components.ProjectTechSection

@Composable
fun ProjectDetailsScreen(project: Project, onBackClicked: () -> Unit) {

    var tImgSize by remember {
        mutableStateOf(30.dp)
    }
    val imgSize = animateDpAsState(
        targetValue = tImgSize,
        animationSpec = spring(
            Spring.DampingRatioLowBouncy,
            Spring.StiffnessLow,
        ), label = ""
    )

    LaunchedEffect(true) {
        tImgSize = 500.dp
    }

    val scrollState = rememberScrollState()
    Column(
        Modifier.fillMaxSize()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colors.background)
            .padding(
                vertical = 20.dp,
                horizontal = 40.dp
            )
    ) {
        MaterialTheme.spacing.standard.Vertical()
        AnimBackButton(onBackClicked)
        MaterialTheme.spacing.large.Vertical()

        Image(
            painter = painterResource(
                project.logo
            ),
            "",
            modifier = Modifier.size(imgSize.value)
        )

        //Tech Section
        MaterialTheme.spacing.standard.Vertical()
        ProjectTechSection(project)
        MaterialTheme.spacing.standard.Vertical()
        Divider(
            color = MaterialTheme.colors.onSecondary
                .copy(alpha = 0.5f),
        )
        MaterialTheme.spacing.large.Vertical()

        //Project Info
        LargeBoldText(project.title)
        MaterialTheme.spacing.medium.Vertical()
        StandardText(
            project.description,
            textAlign = TextAlign.Start,
        )

        MaterialTheme.spacing.xLarge.Vertical()
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            if (project.isAppStore)
                ProjectActionButton(
                    "Open App Store",
                    Res.drawable.apple_logo_black,
                    project.appStoreLink!!
                )
            MaterialTheme.spacing.xxLarge.Horizontal()

            if (project.isPlaystore)
                ProjectActionButton(
                    "Open Play Store",
                    Res.drawable.android_png_icon,
                    project.link!!
                )
            MaterialTheme.spacing.xxLarge.Horizontal()
            if (project.isPlaystore.not() && project.isAppStore.not() &&
                project.link.isNullOrEmpty().not()
            )
                ProjectActionButton(
                    "View Project",
                    project.logo,
                    project.link!!
                )
        }
    }

}