package dev.muthuram.martian.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



data class MarsPhotoModel(
    val photos : ArrayList<MarsImageDataModel>
)

@Parcelize
data class MarsImageDataModel(
    val id: String,
    val sol: Int,
    val img_src: String,
    val camera: CameraModel,
    val earth_date: String,
    val rover: RoverModel
) : Parcelable

@Parcelize
data class CameraModel(
    val name: String,
    val full_name: String,
    val rover_id: String
) : Parcelable

@Parcelize
data class RoverModel(
    val name: String,
    val status: String
) : Parcelable