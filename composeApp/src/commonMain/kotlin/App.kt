
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import core.theme.DevScionWebTheme
import core.theme.WindowSize
import core.utils.Screen
import home.presentation.HomeScreen
import project_details.presentation.ProjectDetailsScreen

@Composable
fun App(windowSize: WindowSize) {

    DevScionWebTheme(windowSize) {
        val currentScreen = remember {
            mutableStateOf<Screen>(Screen.Home)
        }

        Box {
            HomeScreen {
                currentScreen.value = Screen.ProjectDetails(
                    project = it,
                )
            }
            if (currentScreen.value is Screen.ProjectDetails) {
                ProjectDetailsScreen(
                    (currentScreen.value as Screen.ProjectDetails).project
                ) {
                    currentScreen.value = Screen.Home
                }
            }
        }
    }
}