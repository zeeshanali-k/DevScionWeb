@file:OptIn(ExperimentalSharedTransitionApi::class)

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import core.theme.DevScionWebTheme
import core.theme.WindowSize
import core.utils.AppConstants
import core.utils.ScreenHome
import core.utils.ScreenProject
import di.viewModelModule
import home.presentation.HomeScreen
import org.koin.compose.KoinApplication
import project_details.presentation.ProjectDetailsScreen

val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }
val LocalAnimatedContentScope = compositionLocalOf<AnimatedVisibilityScope?> { null }

@Composable
fun App(windowSize: WindowSize) {
    val navController = rememberNavController()
    KoinApplication(application = {
        modules(viewModelModule)
    }) {
        DevScionWebTheme(windowSize) {
            SharedTransitionLayout(Modifier.fillMaxSize()) {
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this@SharedTransitionLayout,
                ) {
                    NavHost(
                        navController,
                        startDestination = ScreenHome,
                    ) {
                        composable<ScreenHome> {
                            CompositionLocalProvider(
                                LocalAnimatedContentScope provides this,
                            ) {
                                HomeScreen {
                                    navController.navigate(ScreenProject(projectId = it.id))
                                }
                            }
                        }

                        composable<ScreenProject> { entry ->
                            CompositionLocalProvider(
                                LocalAnimatedContentScope provides this,
                            ) {
                                val project = AppConstants.getAllProjects()
                                    .firstOrNull { it.id == entry.toRoute<ScreenProject>().projectId }
                                    ?: return@CompositionLocalProvider
                                ProjectDetailsScreen(
                                    project,
                                    onBackClicked = navController::navigateUp,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}