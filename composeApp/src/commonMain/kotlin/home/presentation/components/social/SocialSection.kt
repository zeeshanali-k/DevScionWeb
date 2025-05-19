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
import core.utils.Vertical
import core.utils.getOnLinkClickHandler
import home.domain.model.Social


@Composable
fun SocialSection(modifier: Modifier = Modifier, socialData: List<Social>) {
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
                social = socialData.first(),
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(socialData.first().link)
//                    handleSocialClick(it, context, socialData(context).first().link)
                })
            SocialButton(
                social = socialData[1],
                maxWidth = socialItemWidth,
                onClick = {

                    getOnLinkClickHandler().onClicked(socialData[1].link)
//                    handleSocialClick(it, context, socialData(context)[1].link)
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
                social = socialData[2],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(socialData[2].link)
//                    handleSocialClick(it, context, socialData(context)[2].link)
                })
            SocialButton(
                social = socialData[3],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(socialData[3].link)
//                    handleSocialClick(it, context, socialData(context)[3].link)
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
                social = socialData[4],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onClicked(socialData[4].link)
//                    handleSocialClick(it, context, socialData(context)[4].link)
                })
            SocialButton(
                social = socialData[5],
                maxWidth = socialItemWidth,
                onClick = {
                    getOnLinkClickHandler().onMailClicked("connectzeeshanali@gmail.com")
//                    handleSocialClick(it, context)
                })
        }
    }
}