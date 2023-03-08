package com.thoughtworks.ark.particle.builder

import android.app.Application
import com.thoughtworks.ark.particle.di.ParticleViewModelProvider
import com.thoughtworks.ark.particle.di.ServiceProvider
import com.yunlong.particle.proto.Particle

class ParticleBuilder {

    private val configuration = ParticleConfiguration()

    fun setBaseUrl(baseUrl: String): ParticleBuilder {
        configuration.baseUrl = baseUrl
        return this
    }

    fun setInitialView(initialView: Particle): ParticleBuilder {
        configuration.initialView = initialView
        return this
    }

    fun buildViewModelProvider(context: Application): ParticleViewModelProvider {
        val serviceProvider =
            ServiceProvider(context, configuration.baseUrl, configuration.initialView)

        return ParticleViewModelProvider(serviceProvider.particleRepository)
    }
}
