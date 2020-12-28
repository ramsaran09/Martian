package dev.mustaq.martian.data

import dev.mustaq.martian.model.MarsPhotoModel
import dev.mustaq.martian.network.ServiceApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response


/**
Created by Mustaq Sameer on 28/12/20
 **/
class MockServiceApiForFailScenario : ServiceApi {

    override suspend fun getMarsImages(): Response<MarsPhotoModel> =
        Response.error(400,
            "".toByteArray().toResponseBody("application/json; charset=utf-8".toMediaType())
        )
}