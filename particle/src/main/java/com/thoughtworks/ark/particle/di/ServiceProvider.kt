package com.thoughtworks.ark.particle.di

import android.app.Application
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.thoughtworks.ark.particle.data.source.ParticleService
import com.yunlong.particle.proto.Particle

class ServiceProvider(
    private val context: Application,
    private val baseUrl: String?,
    private val initialView: Particle
) {
    val particleRepository: ParticleRepository by lazy {
        ParticleService(
            context = context,
            baseUrl = baseUrl,
            initialView = initialView
        )
    }
}
