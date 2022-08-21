package android.example.data.storage

import android.example.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}