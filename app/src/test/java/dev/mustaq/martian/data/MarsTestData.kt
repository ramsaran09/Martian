package dev.mustaq.martian.data

import dev.mustaq.martian.model.CameraModel
import dev.mustaq.martian.model.MarsImageDataModel
import dev.mustaq.martian.model.RoverModel

/**
Created by Mustaq Sameer on 28/12/20
 **/
object MarsTestData {

    private val data1 = MarsImageDataModel(
        id = "102",
        sol = 50,
        img_src = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        camera = CameraModel(
            name = "FAZ",
            full_name = "Full Angel Zebra",
            rover_id = "5"
        ),
        earth_date = "2020-12-27",
        rover = RoverModel(
            name = "Curiosity",
            status = "active"
        )
    )

    private val data2 = MarsImageDataModel(
        id = "103",
        sol = 50,
        img_src = "http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG",
        camera = CameraModel(
            name = "FAM",
            full_name = "Full Angel Micro",
            rover_id = "5"
        ),
        earth_date = "2020-12-28",
        rover = RoverModel(
            name = "Curiosity",
            status = "active"
        )
    )

    fun getData() = arrayListOf(data1, data2)

}