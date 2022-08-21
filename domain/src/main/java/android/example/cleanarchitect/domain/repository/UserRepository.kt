package android.example.cleanarchitect.domain.repository

import android.example.cleanarchitect.domain.models.SaveUserNameParam
import android.example.cleanarchitect.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean


    fun getUserName(): UserName
}