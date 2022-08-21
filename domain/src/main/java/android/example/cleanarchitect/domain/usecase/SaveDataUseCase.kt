package android.example.cleanarchitect.domain.usecase

import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.repository.UserRepository

class SaveDataUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean{
        val oldUserName = userRepository.getUserName()
        if (oldUserName.firstName == param.name){
            return true
        }
        val result = userRepository.saveName(saveParam = param)
        return result
    }
}