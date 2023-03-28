package com.thoughtworks.ark.particle.presenter.dispatch

import com.yunlong.particle.proto.Action
import com.yunlong.particle.proto.Event
import com.yunlong.particle.proto.Interaction

fun List<Interaction>.dispatcher(event: Event) = filter {
    it.event.contains(event)
}.forEach { interaction ->
    interaction.action.forEach { action ->
        action.dispatcher()
    }
}

fun Action.dispatcher() {

}
