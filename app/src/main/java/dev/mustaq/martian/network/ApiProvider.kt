package dev.mustaq.martian.network

import android.content.Context
import dev.mustaq.martian.BuildConfig
import dev.mustaq.martian.helper.defaultValue
import dev.mustaq.martian.helper.isInternetAvailable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
Created by Mustaq Sameer on 25/12/20
 **/
object ApiProvider: KoinComponent {

    val context: Context by inject()

    private fun customCache(): Cache {
        val cacheSize = (5 * 1024 * 1024).toLong()
        return Cache(context.cacheDir, cacheSize)
    }

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private fun httpClient() =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor())
            cache(customCache())
            addInterceptor{chain ->
                var request = chain.request()
                request = if (context.isInternetAvailable().defaultValue())
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
        }.build()

    private val retrofit = Retrofit.Builder().apply {
        baseUrl(BuildConfig.BASE_URL)
        client(httpClient())
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    val client : ServiceApi by lazy { retrofit.create(ServiceApi::class.java) }

}