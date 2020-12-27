package dev.mustaq.martian.ui.roverimagedetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.mustaq.martian.R
import dev.mustaq.martian.helper.insertImageIntoView
import dev.mustaq.martian.helper.observeLiveData
import dev.mustaq.martian.model.MarsImageDataModel
import kotlinx.android.synthetic.main.activity_rover_image_detail.*
import kotlinx.android.synthetic.main.model_mar_image_list.*
import kotlinx.android.synthetic.main.model_mar_image_list.uiIvMarsImage
import kotlinx.android.synthetic.main.model_mar_image_list.uiTvEarthDate
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
Created by Mustaq Sameer on 27/12/20
 **/
class RoverImageDetailActivity : AppCompatActivity() {

    private val roverImageDetailViewModel: RoverImageDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rover_image_detail)
        roverImageDetailViewModel.processIntent(intent)
        setupUi()
        setListeners()
    }

    private fun setupUi() {
        roverImageDetailViewModel.roverImageData.observeLiveData(this, ::displayRoverData)
    }

    private fun setListeners(){
        uiToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun displayRoverData(marsImageDataModel: MarsImageDataModel) {
        insertImageIntoView(marsImageDataModel.img_src, uiIvMarsImage)
        uiTvCamera.text = marsImageDataModel.camera.full_name
        uiTvEarthDate.text = marsImageDataModel.earth_date
        uiTvStatus.text = marsImageDataModel.rover.status
        uiTvRoverName.text = marsImageDataModel.rover.name
        uiTvRoverId.text = marsImageDataModel.camera.rover_id.let {
            "Rover id: $it"
        }
    }
}