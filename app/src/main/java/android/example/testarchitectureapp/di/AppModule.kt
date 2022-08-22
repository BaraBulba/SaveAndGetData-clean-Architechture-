package android.example.testarchitectureapp.di

import android.content.Context
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import android.example.testarchitectureapp.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }
    @Provides
    fun provideMainViewModelFactory(
        getDataUseCase: GetDataUseCase,
        saveDataUseCase: SaveDataUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase
        )
    }

}