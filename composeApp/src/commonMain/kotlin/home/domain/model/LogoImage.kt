package home.domain.model

import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.classy_logo
import devscionweb.composeapp.generated.resources.coinpay_logo
import devscionweb.composeapp.generated.resources.feres_logo
import devscionweb.composeapp.generated.resources.vc_panel_logo
import devscionweb.composeapp.generated.resources.zysky_logo

sealed class ProjectLogo(val id: Int) {

    object FeresLogo : ProjectLogo(1)
    object ClassyLogo : ProjectLogo(2)
    object ZYSKYLogo : ProjectLogo(3)
    object CoinPayLogo : ProjectLogo(4)
    object VCPanel : ProjectLogo(5)

    companion object {
        fun fromId(id: Int) = when (id) {
            1 -> FeresLogo
            2 -> ClassyLogo
            3 -> ZYSKYLogo
            4 -> CoinPayLogo
            5 -> VCPanel
            else -> throw IllegalArgumentException("Invalid id")
        }
    }

    fun toDrawableResource() = when (this) {
        FeresLogo -> Res.drawable.feres_logo
        ClassyLogo -> Res.drawable.classy_logo
        ZYSKYLogo -> Res.drawable.zysky_logo
        CoinPayLogo -> Res.drawable.coinpay_logo
        VCPanel -> Res.drawable.vc_panel_logo
    }
}