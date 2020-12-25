package dev.mustaq.martian.model


/**
Created by Mustaq Sameer on 25/12/20
 **/

data class MarsPhotoModel(
    val photos : ArrayList<MarsImageDataModel>
)

data class MarsImageDataModel(
    val id: String,
    val sol: Int,
    val camera: CameraModel,
    val earth_date: String,
    val rover: RoverModel
)

data class CameraModel(
    val name: String,
    val rover_id: String
)

data class RoverModel(
    val name: String,
    val status: String
)