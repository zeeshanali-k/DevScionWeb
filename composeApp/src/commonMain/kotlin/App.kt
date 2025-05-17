import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import core.theme.DevScionWebTheme
import core.theme.WindowSize
import core.utils.Screen
import di.viewModelModule
import home.domain.model.Project
import home.presentation.HomeScreen
import org.koin.compose.KoinApplication
import project_details.presentation.ProjectDetailsScreen

@Composable
fun App(windowSize: WindowSize, navController: NavHostController) {
    KoinApplication(application = {
        modules(viewModelModule)
    }) {
        DevScionWebTheme(windowSize) {
            NavHost(
                navController,
                startDestination = Screen.Home.route,
            ) {
                composable(Screen.Home.route) {
                    HomeScreen {
                        navController.currentBackStackEntry?.savedStateHandle?.set("project", it)
                        navController.navigate(Screen.Project.route)
                    }
                }

                composable(Screen.Project.route) { backStackEntry ->
                    val project =
                        navController.previousBackStackEntry?.savedStateHandle?.get<Project?>("project")
                            ?: return@composable
                    ProjectDetailsScreen(
                        project,
                        onBackClicked = navController::navigateUp,
                    )
                }
            }
        }
    }
}