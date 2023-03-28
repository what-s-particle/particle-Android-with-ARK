package com.thoughtworks.ark.particle.presenter.scaffold

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.dispatch.Dispatcher
import com.thoughtworks.ark.particle.presenter.dispatch.dispatcher
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.yunlong.particle.proto.Event
import com.yunlong.particle.proto.Particle

@Composable
fun ParticleBottomNavigation(
    particle: Particle?,
    navController: NavHostController,
    contract: ParticleContract
) {
    BottomNavigation {
        particle?.bottomBar?.elements?.forEach { item ->
            BottomNavigationItem(
                selected = item.bottomBarItem?.selected ?: false,
                onClick = {
                    item.interactions.dispatcher(Event.TAP_EVENT)
                },
                icon = { item.bottomBarItem?.icon?.Dispatcher(navController, contract) },
                label = { item.bottomBarItem?.text?.Dispatcher(navController, contract) },
                modifier = item.modifier?.Dispatcher() ?: Modifier
            )
        }
    }
}
