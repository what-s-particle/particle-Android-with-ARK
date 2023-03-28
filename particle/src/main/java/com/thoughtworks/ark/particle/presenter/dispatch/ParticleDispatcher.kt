package com.thoughtworks.ark.particle.presenter.dispatch

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.component.TextViewComponent
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Particle

@Composable
fun Particle.Dispatcher(navController: NavHostController, contract: ParticleContract) {
    when {
        label != null -> {
            TextViewComponent(label, this.modifier?.Dispatcher())
        }
    }
}
