package dev.muthuram.martian.repository

import dev.muthuram.martian.responsehandler.CustomResponse
import dev.muthuram.martian.mapper.MarsImageDataMapper
import dev.muthuram.martian.model.MarsImageDataModel
import dev.muthuram.martian.network.ServiceApi
import dev.muthuram.martian.responsehandler.LocalException



class MarsImageRepository(
    private val serviceApi: ServiceApi
) {

    suspend fun getMarsImageDataFromServer(): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> =
        MarsImageDataMapper.map(serviceApi.getMarsImages())

}