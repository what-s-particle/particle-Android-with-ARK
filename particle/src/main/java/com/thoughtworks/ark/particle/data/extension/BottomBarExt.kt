package com.thoughtworks.ark.particle.data.extension

import com.yunlong.particle.proto.BottomBarComponent
import com.yunlong.particle.proto.BottomBarItemComponent
import com.yunlong.particle.proto.Particle


fun BottomBarComponent.findTarget(targetId: String): Particle? {
   return elements.forEach{it.findTarget(targetId)}
}
