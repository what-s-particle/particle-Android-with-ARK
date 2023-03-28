package com.thoughtworks.ark.particle.presenter.mapping

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.yunlong.particle.proto.SizeModifier


fun SizeModifier.toFontSize(): TextUnit {
    return 12.sp
}
