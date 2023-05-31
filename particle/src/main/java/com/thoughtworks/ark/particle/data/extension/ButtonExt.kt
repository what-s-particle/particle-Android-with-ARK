package com.thoughtworks.ark.particle.data.extension

import com.yunlong.particle.proto.ButtonComponent


fun ButtonComponent.findTarget(targetId: String) = elements?.findTarget(targetId)
