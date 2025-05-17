package home.presentation.components.social

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.theme.spacing
import core.utils.AppConstants
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
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.standard,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData.first(),
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData.first().link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context).first().link)
                })
            SocialButton(
                social = AppConstants.SocialData[1],
                maxWidth = socialItemWidth,
                onClick = {

                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[1].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[1].link)
                })
        }
        MaterialTheme.spacing.standard.Vertical()
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.standard,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[2],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[2].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[2].link)
                })
            SocialButton(
                social = AppConstants.SocialData[3],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[3].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[3].link)
                })
        }
        MaterialTheme.spacing.standard.Vertical()
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.standard,
                alignment = Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.standard),
            modifier = rowModifier
        ) {
            SocialButton(
                social = AppConstants.SocialData[4],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(AppConstants.SocialData[4].link)
//                    handleSocialClick(it, context, AppConstants.SocialData(context)[4].link)
                })
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