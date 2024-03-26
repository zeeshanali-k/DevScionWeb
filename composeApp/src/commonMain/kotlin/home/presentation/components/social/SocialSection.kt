package home.presentation.components.social

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.utils.AppConstants


@Composable
fun SocialSection() {
    val rowModifier = remember {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    }
    val socialItemWidth = remember {
        150.dp
    }
    Column(Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData.first(),
                maxWidth = socialItemWidth,
                onClick = {

//                    handleSocialClick(it, context, AppConstants.SocialData(context).first().link)
                })
            SocialButton(
                social = AppConstants.SocialData[1],
                maxWidth = socialItemWidth,
                onClick = {
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[1].link)
                })
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[2],
                maxWidth = socialItemWidth,
                onClick = {
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[2].link)
                })
            SocialButton(
                social = AppConstants.SocialData[3],
                maxWidth = socialItemWidth,
                onClick = {
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[3].link)
                })
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[4],
                maxWidth = socialItemWidth,
                onClick = {
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[4].link)
                })
            SocialButton(
                social = AppConstants.SocialData[5],
                maxWidth = socialItemWidth,
                onClick = {
//                    handleSocialClick(it, context)
                })
        }
    }
}