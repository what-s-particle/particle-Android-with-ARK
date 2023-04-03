package com.thoughtworks.ark.core.network.client

import android.content.Context
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.wire.WireConverterFactory

class ApiEndPoints(private val context: Context, private val networkJson: Json) {
    fun <S> createService(clazz: Class<S>, baseUrl: String): S =
        createService(clazz, baseUrl, HttpClient(context))

    private fun <T : HttpClient, S> createService(
        clazz: Class<S>,
        baseUrl: String,
        httpClient: T,
    ): S {
        val retrofit = createRetrofit(baseUrl, httpClient.okHttpClient)
        return retrofit.create(clazz)
    }

    private fun createRetrofit(baseUrl: String, client: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(baseUrl)
                // TODO 需要自定义Factory，同时支持解析pb 和 json
            .addConverterFactory(WireConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
}
