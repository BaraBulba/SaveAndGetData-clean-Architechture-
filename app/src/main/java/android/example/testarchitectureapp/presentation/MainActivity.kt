package android.example.testarchitectureapp.presentation

import android.example.testarchitectureapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // by lazy{} - создаем классы только тогда, когда они нам понадобятся (способ избежать null
    // pointer exception при передаче applicationContext)

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("AAA", "Activity created")

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