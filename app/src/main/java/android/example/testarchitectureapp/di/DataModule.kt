package android.example.testarchitectureapp.di

import android.content.Context
import android.example.cleanarchitect.domain.repository.UserRepository
import android.example.data.repository.UserRepositoryImplementation
import android.example.data.storage.UserStorage
import android.example.data.storage.sharedprefs.SharedPrefUserStorage
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage{
        return SharedPrefUserStorage(context = context)
    }
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository{
        return UserRepositoryImplementation(userStorage = userStorage)
    }

}