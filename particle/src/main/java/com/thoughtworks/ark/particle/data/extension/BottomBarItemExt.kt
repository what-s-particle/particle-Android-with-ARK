package com.thoughtworks.ark.particle.data.extension

import com.yunlong.particle.proto.BottomBarItemComponent
import com.yunlong.particle.proto.Particle


fun BottomBarItemComponent.findTarget(targetId: String): Particle? {
   return text?.findTarget(targetId) ?: icon?.findTarget(targetId)
}
