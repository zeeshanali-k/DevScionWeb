package core.utils

import kotlinx.browser.window

actual fun getOnLinkClickHandler(): OnLinkClicked {
    return object : OnLinkClicked {
        override fun onClicked(url: String) {
            window.open(url)
        }

        override fun onMailClicked(email: String) {
            window.location.href = "mailto:$email"
        }
    }
}
