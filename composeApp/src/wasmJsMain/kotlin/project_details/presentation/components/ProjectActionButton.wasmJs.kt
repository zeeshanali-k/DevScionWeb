package project_details.presentation.components


actual fun getOnLinkClickHandler(): OnLinkClicked {
    return object : OnLinkClicked {
        override fun onClicked(url: String) {
            openUrl(url)
        }
    }
}

fun openUrl(url: String): Unit = js(
    """{
        window.open(url, '_blank')
        }
        """
)
