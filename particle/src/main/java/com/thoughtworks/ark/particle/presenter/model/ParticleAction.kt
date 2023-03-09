package com.thoughtworks.ark.particle.presenter.model

import com.yunlong.particle.proto.AlertComponent

sealed class ParticleAction {
    data class ShowAlert(val dialog: AlertComponent) : ParticleAction()
}
