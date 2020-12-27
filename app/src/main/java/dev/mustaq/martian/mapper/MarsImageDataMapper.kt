package dev.mustaq.martian.mapper

import dev.mustaq.martian.constants.ERROR_SERVER
import dev.mustaq.martian.responsehandler.CustomResponse
import dev.mustaq.martian.model.MarsImageDataModel
import dev.mustaq.martian.model.MarsPhotoModel
import dev.mustaq.martian.responsehandler.LocalException
import retrofit2.Response


/**
Created by Mustaq Sameer on 27/12/20
 **/
object MarsImageDataMapper {

    fun map(marsDataResponse: Response<MarsPhotoModel>): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> {
        return if (marsDataResponse.isSuccessful && marsDataResponse.code() == 200) {
            CustomResponse.Success(marsDataResponse.body()?.photos ?: arrayListOf())
        } else CustomResponse.Failure(LocalException(ERROR_SERVER))
    }
}