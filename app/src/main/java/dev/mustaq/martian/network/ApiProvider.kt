package dev.mustaq.martian.network

import dev.mustaq.martian.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
Created by Mustaq Sameer on 25/12/20
 **/
object ApiProvider {

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor())
        }.build()

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.BASE_URL)
        client(httpClient())
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    val client : ServiceApi by lazy { retrofit.create(ServiceApi::class.java) }

}