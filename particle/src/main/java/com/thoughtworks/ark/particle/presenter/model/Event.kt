package com.thoughtworks.ark.particle.presenter.model

sealed class Event {
    data class OnParticleEvent(val actions: List<com.yunlong.particle.proto.Action>) : Event()
}
