package com.thoughtworks.ark.particle.model


import com.yunlong.particle.proto.AddressBook
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ParticleClient {
    @Headers("Accept: application/x-protobuf")
    @GET("/moments")
    suspend fun getActions(): Response<AddressBook>

    companion object {
        const val baseUrl = "http://10.0.2.2:8000"
    }
}
