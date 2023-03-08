package com.thoughtworks.ark.particle.data.source


import com.yunlong.particle.proto.Action
import com.yunlong.particle.proto.Particle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ParticleClient {
    @Headers("Accept: application/x-protobuf")
    @GET("/actions")
    suspend fun getActions(): Response<List<Action>>

    @Headers("Accept: application/x-protobuf")
    @GET("/moments")
    suspend fun init(): Response<Particle>

    companion object {
        const val baseUrl = "http://10.0.2.2:8000"
    }
}
