package dev.mustaq.martian.network

import dev.mustaq.martian.BuildConfig
import dev.mustaq.martian.model.MarsPhotoModel
import retrofit2.Response
import retrofit2.http.GET


/**
Created by Mustaq Sameer on 25/12/20
 **/
interface ServiceApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=50&page=1&api_key=${BuildConfig.NASA_API_KEY}")
    suspend fun getMarsImages() : Response<MarsPhotoModel>

}