package com.thoughtworks.ark.particle.data.extension

import com.yunlong.particle.proto.Particle


fun Particle.findTarget(targetId: String): Particle? {
    if (id == targetId) return this
    when {
        button != null -> button.findTarget(id)
        picker != null -> picker.findTarget(id)
        bottomBarItem != null -> bottomBarItem.findTarget(id)
        bottomBar != null -> bottomBar.findTarget(id)
        alert != null -> alert.findTarget(id)
        actionSheet != null -> actionSheet.findTarget(id)
        navGraph != null -> navGraph.findTarget(id)
        screen != null -> screen.findTarget(id)
        topBar != null -> topBar.findTarget(id)
        modalDrawer != null -> modalDrawer.findTarget(id)
        row != null -> row.findTarget(id)
        column != null -> column.findTarget(id)
        box != null -> box.findTarget(id)
        lazyColumn != null -> lazyColumn.findTarget(id)
        lazyRow != null -> lazyRow.findTarget(id)
        tabView != null -> tabView.findTarget(id)
    }
    return null
}

