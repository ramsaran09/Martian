package dev.muthuram.martian.ui.roverimagedetail

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.muthuram.martian.model.MarsImageDataModel



class RoverImageDetailViewModel: ViewModel() {

    private val roverImageDataLd = MutableLiveData<MarsImageDataModel>()

    val roverImageData : LiveData<MarsImageDataModel> = roverImageDataLd

    fun processIntent(intent: Intent?) {
        if (intent != null) {
            roverImageDataLd.value = intent.getParcelableExtra(KEY_MARS_IMAGE_DATA)
        }
    }

    companion object {
        const val KEY_MARS_IMAGE_DATA = "key.mars.image.data"
    }

}