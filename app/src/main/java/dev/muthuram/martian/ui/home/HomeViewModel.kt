package dev.muthuram.martian.ui.home

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.muthuram.martian.model.MarsImageDataModel
import dev.muthuram.martian.model.NavigationModel
import dev.muthuram.martian.repository.MarsImageRepository
import dev.muthuram.martian.responsehandler.CustomResponse.*
import dev.muthuram.martian.ui.roverimagedetail.RoverImageDetailActivity
import dev.muthuram.martian.ui.roverimagedetail.RoverImageDetailViewModel
import kotlinx.coroutines.launch



class HomeViewModel(
    private val marsImageRepository: MarsImageRepository
) : ViewModel() {

    private val navigateLd = MutableLiveData<NavigationModel>()
    private val errorLd = MutableLiveData<String>()
    private val loaderLd = MutableLiveData<Boolean>()
    private val marsImageDataLd = MutableLiveData<ArrayList<MarsImageDataModel>>()

    init {
        getMarsImageData()
    }

    val navigate: LiveData<NavigationModel> = navigateLd
    val error: LiveData<String> = errorLd
    val loader: LiveData<Boolean> = loaderLd
    val marsImageData: LiveData<ArrayList<MarsImageDataModel>> = marsImageDataLd

    private fun getMarsImageData() {
        loaderLd.value = true
        viewModelScope.launch {
            when (val response = marsImageRepository.getMarsImageDataFromServer()) {
                is Success -> marsImageDataLd.value = response.data
                is Failure -> errorLd.value = response.error.message
            }.also { loaderLd.value = false }
        }
    }

    fun moreDetails(marsImageDataModel: MarsImageDataModel) {
        val bundle = Bundle().also {
            it.putParcelable(RoverImageDetailViewModel.KEY_MARS_IMAGE_DATA, marsImageDataModel)
        }
        navigateLd.value = NavigationModel(
            RoverImageDetailActivity::class.java,
            extras = bundle
        )
    }

}