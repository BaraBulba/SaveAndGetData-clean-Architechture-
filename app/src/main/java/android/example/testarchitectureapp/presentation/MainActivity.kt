package android.example.testarchitectureapp.presentation

import android.example.testarchitectureapp.app.App
import android.example.testarchitectureapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    // by lazy{} - создаем классы только тогда, когда они нам понадобятся (способ избежать null
    // pointer exception при передаче applicationContext)

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App)
            .appComponent
            .inject(this)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, vmFactory)
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