package dev.mustaq.martian.di

import dev.mustaq.martian.network.ApiProvider
import dev.mustaq.martian.repository.MarsImageRepository
import dev.mustaq.martian.ui.home.HomeViewModel
import dev.mustaq.martian.ui.roverimagedetail.RoverImageDetailViewModel
import dev.mustaq.martian.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
Created by Mustaq Sameer on 25/12/20
 **/

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