package com.thoughtworks.ark.particle.presenter.scaffold

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.dispatch.Dispatcher
import com.thoughtworks.ark.particle.presenter.dispatch.dispatcher
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Event
import com.yunlong.particle.proto.Particle

@Composable
fun ParticleTopAppBar(
    particle: Particle?,
    navController: NavHostController,
    contract: ParticleContract
) {
    particle?.topBar?.let { topBar ->
        TopAppBar(
            title = { topBar.title?.Dispatcher(navController, contract) },
            navigationIcon = {
                topBar.navigationIcon?.let { navIcon ->
                    IconButton(onClick = {
                        navController.navigateUp()
                        navIcon.interactions.dispatcher(Event.TAP_EVENT)
                    }) {
                        // TODO: should define a icon in proto
                        // TODO: should define accessibility
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            },
            actions = {
                topBar.actions.forEach {
                    it.Dispatcher(
                        navController = navController,
                        contract = contract
                    )
                }
            },
            modifier = particle.modifier?.Dispatcher()
                ?: Modifier.fillMaxWidth(),
            elevation = Dp(topBar.elevation.toFloat())
        )
    }
}
