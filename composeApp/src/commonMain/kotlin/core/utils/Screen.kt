package core.utils

sealed class Screen(val route: String) {

    data object Home : Screen("home")
    data object Project : Screen("project")

}