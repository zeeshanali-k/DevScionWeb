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
import core.utils.AppConstants
import core.utils.Vertical


@Composable
fun SkillsSection(modifier: Modifier = Modifier) {

    Column(modifier) {
        Typist(
            text = "Languages",
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )

        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = AppConstants.LANGUAGES)

        MaterialTheme.spacing.large.Vertical()

        Typist(
            text = "Technologies",
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )
        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = AppConstants.TECH)
        MaterialTheme.spacing.large.Vertical()


        Typist(
            text = "Architecture",
            textStyle = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = MaterialTheme.fontSize.standard
            ),
            typistSpeed = TypistSpeed.FAST
        )
        MaterialTheme.spacing.large.Vertical()
        SkillsRow(skills = AppConstants.OTHER)
        MaterialTheme.spacing.large.Vertical()

    }
}