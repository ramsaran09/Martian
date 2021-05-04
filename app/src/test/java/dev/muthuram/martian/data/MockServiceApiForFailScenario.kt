package dev.muthuram.martian.data

import dev.muthuram.martian.model.MarsPhotoModel
import dev.muthuram.martian.network.ServiceApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response



class MockServiceApiForFailScenario : ServiceApi {

    override suspend fun getMarsImages(): Response<MarsPhotoModel> =
        Response.error(400,
            "".toByteArray().toResponseBody("application/json; charset=utf-8".toMediaType())
        )
}