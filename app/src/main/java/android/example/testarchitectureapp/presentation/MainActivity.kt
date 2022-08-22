package android.example.testarchitectureapp.presentation

import android.example.data.repository.UserRepositoryImplementation
import android.example.testarchitectureapp.databinding.ActivityMainBinding
import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import android.example.data.storage.sharedprefs.SharedPrefUserStorage
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // by lazy{} - создаем классы только тогда, когда они нам понадобятся (способ избежать null
    // pointer exception при передаче applicationContext)


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        vm.resultLive.observe(this) { text ->
            binding.textViewData.text = text
        }
        binding.buttonSaveData.setOnClickListener {
            val text = binding.editTextPutData.text.toString()
            vm.save(text = text)
        }

        binding.buttonGetData.setOnClickListener {
           vm.load()
        }
    }
}