package com.thoughtworks.ark.sample.particle.ui

import com.thoughtworks.ark.particle.builder.ParticleBuilder
import com.thoughtworks.ark.particle.ui.ParticleActivity

class ParticleDemoActivity : ParticleActivity() {
    override val particleBuilder: ParticleBuilder
        get() = ParticleBuilder().setBaseUrl("http://10.0.2.2:8000")
}
