package com.thoughtworks.ark.particle.presenter.dispatch

import com.thoughtworks.ark.particle.presenter.dispatch.extension.dispatch
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Action
import com.yunlong.particle.proto.Particle


fun List<Action>.dispatch(content: Particle, contract: ParticleContract): Particle {
    forEach { action ->
        action.dispatch(content, contract)
    }
    return content.copy()
}

private fun Action.dispatch(content: Particle, contract: ParticleContract) {
    when {
        navItemSelected != null -> navItemSelected.dispatch(content, contract)
    }
}
