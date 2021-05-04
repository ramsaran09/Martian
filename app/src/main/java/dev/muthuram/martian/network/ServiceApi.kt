package dev.muthuram.martian.network

import dev.muthuram.martian.BuildConfig
import dev.muthuram.martian.model.MarsPhotoModel
import retrofit2.Response
import retrofit2.http.GET



interface ServiceApi {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=50&page=1&api_key=${BuildConfig.NASA_API_KEY}")
    suspend fun getMarsImages() : Response<MarsPhotoModel>

}