package android.example.testarchitectureapp.di

import android.example.testarchitectureapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel>{
        MainViewModel(
            getDataUseCase = get(),
            saveDataUseCase = get()
        )
    }

}