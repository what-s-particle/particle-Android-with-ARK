package com.thoughtworks.ark.particle.data.source

import android.content.Context
import com.thoughtworks.ark.core.network.api.ApiService
import com.thoughtworks.ark.core.network.client.ApiEndPoints
import com.thoughtworks.ark.core.network.entity.Result
import com.thoughtworks.ark.particle.data.ParticleRepository
import com.yunlong.particle.proto.Action
import com.yunlong.particle.proto.Particle
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class ParticleService(
    private val context: Context,
    private val baseUrl: String? = null,
    private val initialView: Particle,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val particleClient: ParticleClient =
        ApiEndPoints(context, Json {
            ignoreUnknownKeys = true
        }
        ).createService(
            ParticleClient::class.java,
            baseUrl ?: ParticleClient.baseUrl
        )
) : ApiService(), ParticleRepository {


    override fun getParticle(): Flow<Result<Particle>> {
        return performRequest {
            withContext(dispatcher) {
                particleClient.init()
            }
        }
    }

    override fun getActions(): Flow<Result<List<Action>>> {
        return performRequest {
            withContext(dispatcher) {
                particleClient.getActions()
            }
        }
    }

    override fun getInitialView(): Flow<Result<Particle>> {
        // TODO The url should be fetched from the `initialView`. then call getParticle(URL)
        return getParticle()
    }
}
