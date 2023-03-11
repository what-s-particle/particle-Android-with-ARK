package com.thoughtworks.ark.particle.presenter

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import com.thoughtworks.ark.particle.presenter.model.Event
import com.yunlong.particle.proto.Particle

@Composable
fun ParticleScreen(
    navController: NavHostController,
    destination: Particle,
    contract: ParticleContract
) {
    Scaffold { paddingValues ->
        if (destination.id == "screen1_destination"){
            Button(onClick = { contract.onEvent(Event.OpenDrawer) }) {
                Text(text = destination.id, modifier = Modifier.padding(paddingValues))
            }
        }
        else {
            Text(text = destination.id, modifier = Modifier.padding(paddingValues))
        }
    }

}
