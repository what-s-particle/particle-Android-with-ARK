package com.thoughtworks.ark.particle

import ParticleNavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
            treeState?.let {
                ParticleNavGraph(treeState = it, contract = viewModel.contract)
            }
        }
    }
}
