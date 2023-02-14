package com.thoughtworks.ark.particle.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.thoughtworks.ark.particle.model.ParticleService
import kotlinx.coroutines.launch

open class ParticleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val service = ParticleService(applicationContext)
            var text by remember { mutableStateOf("Click") }
            Button(
                onClick = {
                    scope.launch {
                        service.getActions().collect {

                            when (it) {
                                is com.thoughtworks.ark.core.network.entity.Result.Success -> {
                                    text = it.data?.people?.get(0)?.name ?: "Error1"
                                }
                                else -> {
                                    text = "Error"
                                }
                            }
                        }
                    }
                }) {
                Text(text = text)
            }

        }

    }
}
