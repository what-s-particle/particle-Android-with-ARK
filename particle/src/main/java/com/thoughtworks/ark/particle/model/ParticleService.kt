package com.thoughtworks.ark.particle.model

import android.content.Context
import com.thoughtworks.ark.core.network.api.ApiService
import com.thoughtworks.ark.core.network.client.ApiEndPoints
import com.thoughtworks.ark.core.network.entity.Result
import com.yunlong.particle.proto.AddressBook
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class ParticleService(
    context: Context,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApiService(), ParticleRepository {
    private val particleClient: ParticleClient =
        ApiEndPoints(context, Json {
            ignoreUnknownKeys = true
        }
        ).createService(
            ParticleClient::class.java,
            ParticleClient.baseUrl
        )

    override suspend fun getActions(): Flow<Result<AddressBook>> =
        withContext(coroutineDispatcher) {
            performRequest {
                particleClient.getActions()
            }
        }
}
