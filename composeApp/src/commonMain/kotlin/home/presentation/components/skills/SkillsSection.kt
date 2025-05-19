package home.presentation.components.skills

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.devscion.typistcmp.Typist
import com.devscion.typistcmp.TypistSpeed
import core.theme.fontSize
import core.theme.interFamily
import core.theme.spacing
import core.utils.Vertical
import devscionweb.composeapp.generated.resources.Res
import devscionweb.composeapp.generated.resources.architecture
import devscionweb.composeapp.generated.resources.languages
import devscionweb.composeapp.generated.resources.technologies
import home.presentation.Skills
import org.jetbrains.compose.resources.stringResource


@Composable
fun SkillsSection(modifier: Modifier = Modifier, skills: Skills) {

    Column(modifier) {
        Typist(
            text = stringResource(Res.string.languages),
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )

        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = skills.languages)

        MaterialTheme.spacing.large.Vertical()

        Typist(
            text = stringResource(Res.string.technologies),
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )
        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = skills.tech)
        MaterialTheme.spacing.large.Vertical()


        Typist(
            text = stringResource(Res.string.architecture),
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )
        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = skills.other)
        MaterialTheme.spacing.large.Vertical()

    }
}