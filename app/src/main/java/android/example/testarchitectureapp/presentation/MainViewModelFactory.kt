package android.example.testarchitectureapp.presentation

import android.content.Context
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import android.example.data.repository.UserRepositoryImplementation
import android.example.data.storage.sharedprefs.SharedPrefUserStorage
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Класс который ответсвенный за создание вью модели и созданием юз кейсов и репозиториев

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = context)) }
    private val getDataUseCase by lazy(LazyThreadSafetyMode.NONE)
    { GetDataUseCase(userRepository = userRepository) }
    private val saveDataUseCase by lazy(LazyThreadSafetyMode.NONE)
    { SaveDataUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getDataUseCase = getDataUseCase,
            saveDataUseCase = saveDataUseCase
        ) as T
    }
}