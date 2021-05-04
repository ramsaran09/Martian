package dev.muthuram.martian.data

import dev.muthuram.martian.model.MarsPhotoModel
import dev.muthuram.martian.network.ServiceApi
import retrofit2.Response



class MockServiceApi : ServiceApi {

    override suspend fun getMarsImages(): Response<MarsPhotoModel> {
        return Response.success(MarsPhotoModel(MarsTestData.getData()))
    }
}
