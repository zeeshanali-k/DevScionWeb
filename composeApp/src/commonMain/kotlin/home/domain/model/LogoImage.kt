package home.domain.model

import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.classy_logo
import devscionweb.composeapp.generated.resources.coinpay_logo
import devscionweb.composeapp.generated.resources.vc_panel_logo
import devscionweb.composeapp.generated.resources.zysky_logo

sealed class ProjectLogo(val id: Int) {

    object ClassyLogo : ProjectLogo(1)
    object ZYSKYLogo : ProjectLogo(2)
    object CoinPayLogo : ProjectLogo(3)
    object VCPanel : ProjectLogo(4)

    companion object {
        fun fromId(id: Int) = when (id) {
            1 -> ClassyLogo
            2 -> ZYSKYLogo
            3 -> CoinPayLogo
            4 -> VCPanel
            else -> throw IllegalArgumentException("Invalid id")
        }
    }

    fun toDrawableResource() = when (this) {
        ClassyLogo -> Res.drawable.classy_logo
        ZYSKYLogo -> Res.drawable.zysky_logo
        CoinPayLogo -> Res.drawable.coinpay_logo
        VCPanel -> Res.drawable.vc_panel_logo
    }
}