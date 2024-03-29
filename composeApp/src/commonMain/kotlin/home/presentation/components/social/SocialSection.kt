package home.presentation.components.social

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.theme.spacing
import core.utils.AppConstants
import core.utils.Horizontal
import core.utils.Vertical
import core.utils.getOnLinkClickHandler


@Composable
fun SocialSection(modifier: Modifier = Modifier) {
    val rowModifier = remember {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    }
    val socialItemWidth = remember {
        300.dp
    }
    Column(modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData.first(),
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData.first().link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context).first().link)
                })
            MaterialTheme.spacing.standard.Horizontal()
            SocialButton(
                social = AppConstants.SocialData[1],
                maxWidth = socialItemWidth,
                onClick = {

                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[1].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[1].link)
                })
        }
        MaterialTheme.spacing.standard.Vertical()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[2],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[2].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[2].link)
                })
            MaterialTheme.spacing.standard.Horizontal()
            SocialButton(
                social = AppConstants.SocialData[3],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[3].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[3].link)
                })
        }
        MaterialTheme.spacing.standard.Vertical()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[4],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[4].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[4].link)
                })
            MaterialTheme.spacing.standard.Horizontal()
            SocialButton(
                social = AppConstants.SocialData[5],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onMailClicked("connectzeeshanali@gmail.com")
//                    handleSocialClick(it, context)
                })
        }
    }
}