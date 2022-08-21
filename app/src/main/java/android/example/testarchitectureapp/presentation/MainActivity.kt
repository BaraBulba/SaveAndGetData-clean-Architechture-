package android.example.testarchitectureapp.presentation

import android.app.Activity
import android.example.data.repository.UserRepositoryImplementation
import android.example.testarchitectureapp.databinding.ActivityMainBinding
import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import android.example.data.storage.UserStorage
import android.example.data.storage.sharedprefs.SharedPrefUserStorage
import android.os.Bundle

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    // by lazy{} - создаем классы только тогда, когда они нам понадобятся (способ избежать null
    // pointer exception при передаче applicationContext)
    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImplementation(userStorage = SharedPrefUserStorage(context = applicationContext)) }
    private val getDataUseCase by lazy(LazyThreadSafetyMode.NONE)
    { GetDataUseCase(userRepository = userRepository) }
    private val saveDataUseCase by lazy(LazyThreadSafetyMode.NONE)
    { SaveDataUseCase(userRepository = userRepository) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveData.setOnClickListener {
            val text = binding.editTextPutData.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveDataUseCase.execute(param = params)
            binding.textViewData.text = "Save results = $result"
        }

        binding.buttonGetData.setOnClickListener {
            val userName = getDataUseCase.execute()
            binding.textViewData.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}