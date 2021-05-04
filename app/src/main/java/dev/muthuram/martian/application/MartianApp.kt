package dev.muthuram.martian.application

import android.app.Application
import dev.muthuram.martian.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


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