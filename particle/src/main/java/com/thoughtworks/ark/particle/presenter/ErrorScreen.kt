package com.thoughtworks.ark.particle.presenter

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.thoughtworks.ark.particle.presenter.model.ParticleContract

@Composable
fun ErrorScreen(
    navController: NavHostController,
    contract: ParticleContract
) {
    Text(text = "error page")
}
