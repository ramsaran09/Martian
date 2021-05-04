package dev.muthuram.martian.ui.roverimagedetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.muthuram.martian.R
import dev.muthuram.martian.helper.insertImageIntoView
import dev.muthuram.martian.helper.observeLiveData
import dev.muthuram.martian.model.MarsImageDataModel
import kotlinx.android.synthetic.main.activity_rover_image_detail.*
import kotlinx.android.synthetic.main.activity_rover_image_detail.uiIvMarsImage
import kotlinx.android.synthetic.main.activity_rover_image_detail.uiTvEarthDate
import org.koin.androidx.viewmodel.ext.android.viewModel


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
        uiTvCameraName.text = marsImageDataModel.camera.full_name
        uiTvEarthDate.text = marsImageDataModel.earth_date
        uiTvStatus.text = marsImageDataModel.rover.status
        uiTvRoverName.text = marsImageDataModel.rover.name
        uiTvRoverId.text = marsImageDataModel.camera.rover_id.let {
            "Rover id: $it"
        }
    }
}