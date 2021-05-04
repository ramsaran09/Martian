package dev.muthuram.martian.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.muthuram.martian.R
import dev.muthuram.martian.helper.observeLiveData
import dev.muthuram.martian.helper.startActivity
import dev.muthuram.martian.model.NavigationModel
import org.koin.androidx.viewmodel.ext.android.viewModel



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