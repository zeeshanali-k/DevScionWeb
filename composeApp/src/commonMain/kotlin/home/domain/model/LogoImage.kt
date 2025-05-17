package home.domain.model

import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.classy_logo
import devscionweb.composeapp.generated.resources.coinpay_logo
import devscionweb.composeapp.generated.resources.flutter
import devscionweb.composeapp.generated.resources.vc_panel_logo
import devscionweb.composeapp.generated.resources.zysky_logo
import home.domain.model.ProjectLogo.ClassyLogo
import home.domain.model.ProjectLogo.ZYSKYLogo
import kotlinx.serialization.Serializable

@Serializable
sealed class ProjectLogo() {

    object ClassyLogo : ProjectLogo()
    object ZYSKYLogo : ProjectLogo()
    object CoinPayLogo : ProjectLogo()
    object VCPanel : ProjectLogo()

    fun toDrawableResource() = when (this) {
        ClassyLogo -> Res.drawable.classy_logo
        ZYSKYLogo -> Res.drawable.zysky_logo
        CoinPayLogo -> Res.drawable.coinpay_logo
        VCPanel -> Res.drawable.vc_panel_logo
    }
}
