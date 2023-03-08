package com.thoughtworks.ark.particle.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import com.thoughtworks.ark.particle.builder.ParticleBuilder

abstract class ParticleActivity : ComponentActivity() {

    abstract val particleBuilder: ParticleBuilder

    protected val viewModel: ParticleViewModel by lazy {
        ViewModelProvider(
            this,
            particleBuilder.buildViewModelProvider(application)
        )[ParticleViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadData()

        setContent {
            val treeState by viewModel.treeState.collectAsState()
            var text by remember { mutableStateOf("Loading") }
            treeState?.let {
                text = it.id
            }
            Text(text = text)
        }
    }
}
