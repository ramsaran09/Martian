package dev.mustaq.martian.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mustaq.martian.model.NavigationModel
import dev.mustaq.martian.ui.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
Created by Mustaq Sameer on 25/12/20
 **/
class SplashViewModel : ViewModel() {

    private val navigateLd = MutableLiveData<NavigationModel>()

    val navigate: LiveData<NavigationModel> = navigateLd

    init {
        viewModelScope.launch {
            delay(1500)
            navigateLd.value = NavigationModel(
                HomeActivity::class.java,
                finishCurrent = true
            )
        }
    }

}