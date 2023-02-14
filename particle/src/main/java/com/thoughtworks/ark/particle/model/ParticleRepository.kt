package com.thoughtworks.ark.particle.model

import com.thoughtworks.ark.core.network.entity.Result
import com.yunlong.particle.proto.AddressBook
import kotlinx.coroutines.flow.Flow

interface ParticleRepository {
    suspend fun getActions(): Flow<Result<AddressBook>>
}
