package com.thoughtworks.ark.particle.builder

import com.yunlong.particle.proto.Particle

class ParticleConfiguration {
    var initialView = getInitialView()

    var baseUrl: String? = null


    @JvmName("getInitialViewParticle")
    private fun getInitialView(): Particle {
        //TODO Default view to load navGraph

        return Particle(id = "123")
    }
} 
