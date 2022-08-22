package android.example.testarchitectureapp.presentation

import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    val getDataUseCase: GetDataUseCase,
    val saveDataUseCase: SaveDataUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase
        ) as T
    }
}