package dev.mustaq.martian.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mustaq.martian.model.MarsImageDataModel
import dev.mustaq.martian.repository.MarsImageRepository
import dev.mustaq.martian.responsehandler.CustomResponse.*
import kotlinx.coroutines.launch


/**
Created by Mustaq Sameer on 27/12/20
 **/
class HomeViewModel(
    private val marsImageRepository: MarsImageRepository
) : ViewModel() {

    private val marsImageDataLd = MutableLiveData<ArrayList<MarsImageDataModel>>()
    private val errorLd = MutableLiveData<String>()

    init {
        getMarsImageData()
    }

    val marsImageData : LiveData<ArrayList<MarsImageDataModel>> = marsImageDataLd
    val error: LiveData<String> = errorLd

    private fun getMarsImageData() {
        viewModelScope.launch {
            when(val response = marsImageRepository.getMarsImageDataFromServer()) {
                is Success -> marsImageDataLd.value = response.data
                is Failure -> errorLd.value = response.error.message
            }
        }
    }

}