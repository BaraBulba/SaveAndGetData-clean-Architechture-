package android.example.testarchitectureapp.di

import android.example.cleanarchitect.domain.repository.UserRepository
import android.example.data.repository.UserRepositoryImplementation
import android.example.data.storage.UserStorage
import android.example.data.storage.sharedprefs.SharedPrefUserStorage
import org.koin.dsl.module

val dataModule = module {

    // Стореджи и репозитории, чаще всего сингл

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImplementation(userStorage = get())
    }


}