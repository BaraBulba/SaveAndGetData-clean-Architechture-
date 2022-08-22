package android.example.testarchitectureapp.app

import android.app.Application
import android.example.testarchitectureapp.di.AppComponent
import android.example.testarchitectureapp.di.AppModule
import android.example.testarchitectureapp.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}