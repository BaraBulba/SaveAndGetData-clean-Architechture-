package android.example.testarchitectureapp.presentation

import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.usecase.GetDataUseCase
import android.example.cleanarchitect.domain.usecase.SaveDataUseCase
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val getDataUseCase: GetDataUseCase,
    private val saveDataUseCase: SaveDataUseCase
    ) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable


    init {
        Log.e("AAA", "Vm Created")
    }

    override fun onCleared() {
        Log.e("AAA", "Vm cleared")
        super.onCleared()
    }

    fun save(text: String){
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveDataUseCase.execute(param = params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load(){
        val userName = getDataUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}