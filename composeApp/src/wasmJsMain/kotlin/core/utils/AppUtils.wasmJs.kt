package core.utils

actual fun getOnLinkClickHandler(): OnLinkClicked {
    return object : OnLinkClicked {
        override fun onClicked(url: String) {
            openUrl(url)
        }

        override fun onMailClicked(email: String) {
            openMail(email)
        }
    }
}

fun openUrl(url: String): Unit = js(
    """{
        window.open(url, '_blank')
        }
        """
)

fun openMail(email: String): Unit = js(
    """{
        window.location.href = "mailto:email";
        }
        """
)
