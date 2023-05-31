package com.thoughtworks.ark.particle.data.extension

import com.yunlong.particle.proto.PickerComponent


fun PickerComponent.findTarget(targetId: String) = iconContent?.findTarget(targetId)
