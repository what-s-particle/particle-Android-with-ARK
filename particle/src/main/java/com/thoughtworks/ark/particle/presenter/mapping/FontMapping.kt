package com.thoughtworks.ark.particle.presenter.mapping

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import com.yunlong.particle.proto.TextComponent
import com.yunlong.particle.proto.FontFamily as ParticleFontFamily


fun ParticleFontFamily.toFamily(): SystemFontFamily {
    return FontFamily.Default
}


fun TextComponent.toStyle(): TextStyle {
    return TextStyle(
        fontWeight = if (bold == true) FontWeight.Bold else FontWeight.Normal,
        fontStyle = if (italic == true) FontStyle.Italic else FontStyle.Normal
    )
}
