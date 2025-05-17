package core.theme

enum class WindowSize {
    COMPACT,
    MEDIUM,
    EXPANDED;

    // Factory method that creates an instance of the class based on window width
    companion object {
        fun basedOnWidth(windowWidth: Double): WindowSize {
            return when {
                windowWidth < 1000 -> COMPACT
                windowWidth < 1200 -> MEDIUM
                else -> EXPANDED
            }
        }
    }
}