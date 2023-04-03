package com.thoughtworks.ark.particle.presenter.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.DrawerState
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.thoughtworks.ark.particle.presenter.model.Action
import com.thoughtworks.ark.particle.presenter.model.ParticleContract
import kotlinx.coroutines.CoroutineScope


@Composable
fun ParticleModalDrawer(
    drawerState: DrawerState,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    contract: ParticleContract,
    content: @Composable () -> Unit
) {
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Button(onClick = { contract.onAction(Action.NavigateTo("screen2")) }) {
                    Text(text = "drawerContent")
                }
            }

        }
    ) {
        content()
    }
}

