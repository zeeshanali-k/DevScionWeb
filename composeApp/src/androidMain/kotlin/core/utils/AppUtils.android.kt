package core.utils

actual fun getOnLinkClickHandler(): OnLinkClicked {
    return (object : OnLinkClicked {
        override fun onClicked(url: String) {

        }

        override fun onMailClicked(email: String) {

        }
    })
}