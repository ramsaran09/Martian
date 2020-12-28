package dev.mustaq.martian.data

import dev.mustaq.martian.model.MarsPhotoModel
import dev.mustaq.martian.network.ServiceApi
import retrofit2.Response


/**
Created by Mustaq Sameer on 28/12/20
 **/
class MockServiceApi : ServiceApi {

    override suspend fun getMarsImages(): Response<MarsPhotoModel> {
        return Response.success(MarsPhotoModel(MarsTestData.getData()))
    }
}
