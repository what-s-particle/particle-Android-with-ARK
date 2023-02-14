package com.thoughtworks.ark.core.network.client

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.wire.WireConverterFactory

class ApiEndPoints(private val context: Context, private val networkJson: Json) {
    fun <S> createService(clazz: Class<S>, baseUrl: String): S =
        createService(clazz, baseUrl, HttpClient(context))

    fun <T : HttpClient, S> createService(
        clazz: Class<S>,
        baseUrl: String,
        httpClient: T,
    ): S {
        val retrofit = createRetrofit(baseUrl, httpClient.okHttpClient)
        return retrofit.create(clazz)
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun createRetrofit(baseUrl: String, client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(WireConverterFactory.create())
            .client(client)
            .build()

    companion object {
        private val jsonContentType = "application/json".toMediaType()
    }
}
