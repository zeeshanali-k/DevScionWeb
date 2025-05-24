package home.domain.model


sealed class TechnicalSkill(val title: String) {
    data object Android : TechnicalSkill("Android Developer")
    data object KMP : TechnicalSkill("KMP & CMP Developer")
}