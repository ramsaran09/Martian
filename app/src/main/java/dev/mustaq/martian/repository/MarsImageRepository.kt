package dev.mustaq.martian.repository

import dev.mustaq.martian.responsehandler.CustomResponse
import dev.mustaq.martian.mapper.MarsImageDataMapper
import dev.mustaq.martian.model.MarsImageDataModel
import dev.mustaq.martian.network.ServiceApi
import dev.mustaq.martian.responsehandler.LocalException


/**
Created by Mustaq Sameer on 26/12/20
 **/
class MarsImageRepository(
    private val serviceApi: ServiceApi
) {

    suspend fun getMarsImageDataFromServer(): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> =
        MarsImageDataMapper.map(serviceApi.getMarsImages())

}