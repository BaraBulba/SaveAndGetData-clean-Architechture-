package android.example.testarchitectureapp.di

import android.example.cleanarchitect.domain.repository.UserRepository
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(userRepository: UserRepository): GetDataUseCase{
        return GetDataUseCase(userRepository = userRepository)
    }
    @Provides
    fun provideSaveDataUseCase(userRepository: UserRepository): SaveDataUseCase{
        return SaveDataUseCase(userRepository = userRepository)
    }

}