package com.thoughtworks.ark.particle.data

import com.thoughtworks.ark.core.network.entity.Result
import com.yunlong.particle.proto.Action
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.flow.Flow

interface ParticleRepository {
    fun getParticle(): Flow<Result<Particle>>
    fun getActions(): Flow<Result<List<Action>>>

    // TODO Get an initialization data (navGraph) should pass an Action, not a URL.
    //  And allows users to configure.
    fun getInitialView(): Flow<Result<Particle>>
}
