package com.thoughtworks.ark.particle.presenter.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.thoughtworks.ark.particle.presenter.mapping.toColor
import com.thoughtworks.ark.particle.presenter.mapping.toFamily
import com.thoughtworks.ark.particle.presenter.mapping.toFontSize
import com.yunlong.particle.proto.TextComponent

@Composable
fun TextViewComponent(particle: TextComponent, modifier: Modifier?) {
    Text(
        text = particle.content,
        modifier = modifier ?: Modifier,
        color = particle.color?.toColor() ?: Color.Unspecified,
        fontSize = particle.fontSize?.toFontSize() ?: TextUnit.Unspecified,
        fontFamily = particle.fontFamily?.toFamily(),
        textDecoration = if (particle.underline == true) TextDecoration.Underline else if (particle.strikethrough == true) TextDecoration.LineThrough else null
    )
}
