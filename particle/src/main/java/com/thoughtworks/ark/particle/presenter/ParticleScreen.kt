package com.thoughtworks.ark.particle.presenter

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.dispatch.Dispatcher
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.thoughtworks.ark.particle.presenter.scaffold.ParticleBottomNavigation
import com.thoughtworks.ark.particle.presenter.scaffold.ParticleTopAppBar
import com.yunlong.particle.proto.Particle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ParticleScreen(
    particle: Particle,
    navController: NavHostController,
    contract: ParticleContract
) {
    particle.screen?.let { screen ->
        Scaffold(
            modifier = particle.modifier?.Dispatcher() ?: Modifier,
            topBar = { ParticleTopAppBar(screen.topBar, navController, contract) },
            bottomBar = { ParticleBottomNavigation(screen.bottomBar, navController, contract) }

        ) {
            screen.content?.Dispatcher(navController, contract)
        }
    } ?: ErrorScreen(navController = navController, contract = contract)


}
