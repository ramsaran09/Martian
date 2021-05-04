package dev.muthuram.martian.di

import dev.muthuram.martian.network.ApiProvider
import dev.muthuram.martian.repository.MarsImageRepository
import dev.muthuram.martian.ui.home.HomeViewModel
import dev.muthuram.martian.ui.roverimagedetail.RoverImageDetailViewModel
import dev.muthuram.martian.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module




object AppModule {

    private val viewModelModules = module {
        viewModel { SplashViewModel() }
        viewModel { HomeViewModel(get()) }
        viewModel { RoverImageDetailViewModel() }
    }

    private val repoModules = module {
        single { MarsImageRepository(get()) }
    }

    private val commonModules = module {
        single { ApiProvider.client }
    }

    fun appModules() = viewModelModules + repoModules + commonModules

}