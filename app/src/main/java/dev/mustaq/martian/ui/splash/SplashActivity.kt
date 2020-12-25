package dev.mustaq.martian.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.mustaq.martian.R
import dev.mustaq.martian.helper.observeLiveData
import dev.mustaq.martian.helper.startActivity
import dev.mustaq.martian.model.NavigationModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
Created by Mustaq Sameer on 25/12/20
 **/

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupUi()
    }

    private fun setupUi() {
        splashViewModel.navigate.observeLiveData(this, ::navigate)
    }

    private fun navigate(navigationModel: NavigationModel) {
        startActivity(navigationModel)
    }
}