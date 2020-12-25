package dev.mustaq.martian.application

import android.app.Application
import dev.mustaq.martian.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**
Created by Mustaq Sameer on 25/12/20
 **/
class MartianApp : Application() {

    override fun onCreate() {
        super.onCreate()
        configKoin()
    }

    private fun configKoin() {
        startKoin {
            androidContext(this@MartianApp)
            modules(AppModule.appModules())
        }
    }
}