package android.example.data.repository

import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.models.UserName
import android.example.cleanarchitect.domain.repository.UserRepository
import android.example.data.storage.models.User
import android.example.data.storage.UserStorage

// Связующее звено между доменом и датой

class UserRepositoryImplementation(private val userStorage: UserStorage): UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean{
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getUserName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName{
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }
}