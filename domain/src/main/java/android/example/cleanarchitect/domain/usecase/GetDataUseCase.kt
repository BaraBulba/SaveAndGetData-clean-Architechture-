package android.example.cleanarchitect.domain.usecase

import android.example.cleanarchitect.domain.models.UserName
import android.example.cleanarchitect.domain.repository.UserRepository

class GetDataUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getUserName()
    }
}