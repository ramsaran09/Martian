package dev.mustaq.martian.di

import dev.mustaq.martian.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
Created by Mustaq Sameer on 25/12/20
 **/

object AppModule {

    private val viewModelModules = module {
       viewModel { SplashViewModel() }
    }

    private val repoModules = module {

    }

    private val commonModules = module {

    }

    fun appModules() = viewModelModules + repoModules + commonModules

}