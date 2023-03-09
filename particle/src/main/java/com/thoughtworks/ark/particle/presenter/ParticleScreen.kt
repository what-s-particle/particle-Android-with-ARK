package com.thoughtworks.ark.particle.presenter

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.ParticleContract
import com.yunlong.particle.proto.Particle

@Composable
fun ParticleScreen(
    navController: NavHostController,
    treeState: Particle,
    contract: ParticleContract
) {
    Text(text = treeState.id)
}
