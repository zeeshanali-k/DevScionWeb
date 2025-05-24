package core.utils

import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.github
import devscionweb.composeapp.generated.resources.gmail
import devscionweb.composeapp.generated.resources.linkedin
import devscionweb.composeapp.generated.resources.medium_icon
import devscionweb.composeapp.generated.resources.stack_overflow
import devscionweb.composeapp.generated.resources.youtube_icon
import home.domain.model.Project
import home.domain.model.ProjectLogo
import home.domain.model.Social
import home.domain.model.SocialMedia
import kotlin.uuid.ExperimentalUuidApi

object AppConstants {

    const val PORTFOLIO_APP =
        "https://play.google.com/store/apps/details?id=com.techsensei.zportfolio&hl=en&gl=US"

    val SocialData = listOf(
        Social(
            SocialMedia.LINKEDIN,
            "Connect",
            Res.drawable.linkedin,
            "https://www.linkedin.com/in/zeeshan-ali-311b511b7/"
        ),
        Social(
            SocialMedia.MEDIUM,
            "Medium",
            Res.drawable.medium_icon,
            "https://zeeshan-ali.medium.com/"
        ),
        Social(
            SocialMedia.GITHUB,
            "Github",
            Res.drawable.github,
            "https://github.com/zeeshanali-k"
        ),
        Social(
            SocialMedia.STACK_OVERFLOW,
            "Stackoverflow",
            Res.drawable.stack_overflow,
            "https://stackoverflow.com/users/12803398/zeeshan-ali"
        ),
        Social(
            SocialMedia.YOUTUBE,
            "Visit Channel",
            Res.drawable.youtube_icon,
            "https://www.youtube.com/@devscion"
        ),
        Social(
            SocialMedia.GMAIL,
            "Mail Me",
            Res.drawable.gmail,
            ""
        )
    )

    val LANGUAGES = listOf(
        "Java", "Kotlin", "Dart", "PHP", "Python"
    )
    val TECH = listOf(
        "Android", "Flutter (Android/IOS Hybrid Apps)", "KMM", "Laravel (Backend)"
    )
    val OTHER = listOf(
        "MVVM", "Clean Architecture", "Agile Development"
    )

    @OptIn(ExperimentalUuidApi::class)
    fun getAllProjects() =
        listOf(
            Project(
                id = ProjectLogo.FeresLogo.id.toString(),
                title = "Feres",
                description = "Ethiopia's Leading Taxi App built entirely in KMP for Shared Business and Compose Multiplatform for Shared (More than 90%) UI.",
                isAndroid = false,
                isHybrid = false,
                isKMP = true,
                isPlaystore = true,
                isAppStore = true,
                link = "https://play.google.com/store/apps/details?id=com.feres.user&hl=en",
                appStoreLink = "https://apps.apple.com/us/app/feres/id1477739364",
                logo = ProjectLogo.FeresLogo.id,
                tech = listOf(
                    "Kotlin", "Compose Multiplatform"
                )
            ),
            Project(
                id = ProjectLogo.ClassyLogo.id.toString(),
                title = "Classy",
                description = "A KMP Open Source Text to Image and Image Captioning app for Mobile, Web and Desktop",
                isAndroid = false,
                isHybrid = false,
                isKMP = true,
                isPlaystore = false,
                isAppStore = false,
                link = "https://github.com/zeeshanali-k/classy",
                logo = ProjectLogo.ClassyLogo.id,
                tech = listOf(
                    "Kotlin", "Compose Multiplatform"
                )
            ),
            Project(
                id = ProjectLogo.ZYSKYLogo.id.toString(),
                title = "ZYSKY",
                description = "A Benefits application for ZYSKY system users built using Flutter. It has different modules including user app and admin panel, both built in Flutter and Flutter Web respectively.\n" +
                        "Partners and Employers Portal: https://pp.zysky.pl",
                isAndroid = false,
                isHybrid = true,
                isKMP = false,
                isPlaystore = true,
                isAppStore = true,
                link = "https://play.google.com/store/apps/details?id=com.zysky.zysky",
                appStoreLink = "https://apps.apple.com/pk/app/zysky/id6477992573",
                logo = ProjectLogo.ZYSKYLogo.id,
                tech = listOf(
                    "Dart", "Flutter", "Flutter Web"
                )
            ),
            Project(
                id = ProjectLogo.CoinPayLogo.id.toString(),
                title = "CoinPay",
                description = "A full fledged crypto wallet with all the features, including sending, receiving and balance checking with support for multiple blockchains like Ethereum, Polygon, Binance Smart Chain etc. The app also has the feature to save address in Address Book for quick use.",
                isAndroid = true,
                isHybrid = false,
                isKMP = false,
                isPlaystore = false,
                isAppStore = false,
                link = "https://drive.google.com/file/d/1eEUgP5R-nX0meBGTpQA9qhruBVOcSh26/view?usp=sharing",
                logo = ProjectLogo.CoinPayLogo.id,
                tech = listOf(
                    "Kotlin", "Blockchain", "Web3J"
                )
            ),
            Project(
                id = ProjectLogo.VCPanel.id.toString(),
                title = "VC Panel",
                description = "VC Panel is Vehicle Tracking Anti Theft system. It allows you to track your vehicle, by attaching a device, from your mobile phone. It has following features:\n" +
                        "\n" +
                        "->You can Set fences and get notified whenever the vehicle enters or leaves fence\n" +
                        "->There a vast number of features including ignition alert, anti theft alert, etc.\n" +
                        "->You can lock your vehicle from mobile app in case of theft.\n" +
                        "->Live location and analytics.\n" +
                        "->Push Notifications Alert.\n" +
                        "and many more features. The purpose of this project is to make people feel safe about their vehicles and prevent vehicles from theft.",
                isAndroid = true,
                isHybrid = false,
                isKMP = false,
                isPlaystore = true,
                isAppStore = false,
                link = "https://play.google.com/store/apps/details?id=com.mtn.vcpanel",
                logo = ProjectLogo.VCPanel.id,
                tech = listOf(
                    "Kotlin", "PHP - Laravel",
                )
            ),
        )

}

