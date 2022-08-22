package android.example.testarchitectureapp.di

import android.example.testarchitectureapp.presentation.MainActivity
import dagger.Component


// Занимается внедрением зависимостей

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}