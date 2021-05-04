package dev.muthuram.martian.mapper

import dev.muthuram.martian.constants.ERROR_SERVER
import dev.muthuram.martian.responsehandler.CustomResponse
import dev.muthuram.martian.model.MarsImageDataModel
import dev.muthuram.martian.model.MarsPhotoModel
import dev.muthuram.martian.responsehandler.LocalException
import retrofit2.Response


object MarsImageDataMapper {

    fun map(marsDataResponse: Response<MarsPhotoModel>): CustomResponse<ArrayList<MarsImageDataModel>, LocalException> {
        return if (marsDataResponse.isSuccessful && marsDataResponse.code() == 200) {
            CustomResponse.Success(marsDataResponse.body()?.photos ?: arrayListOf())
        } else CustomResponse.Failure(LocalException(ERROR_SERVER))
    }
}