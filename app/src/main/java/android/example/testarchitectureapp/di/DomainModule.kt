package android.example.testarchitectureapp.di

import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import org.koin.dsl.module

val domainModule = module {

    // Юз кейсы, чаще всего фектори

    factory<GetDataUseCase> {
        GetDataUseCase(userRepository = get())
    }

    factory<SaveDataUseCase> {
        SaveDataUseCase(userRepository = get())
    }

}