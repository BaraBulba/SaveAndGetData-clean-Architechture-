package android.example.data.storage.sharedprefs

import android.content.Context
import android.example.data.storage.UserStorage
import android.example.data.storage.models.User

private const val SHARED_PREFS = "shared_prefs"
private const val KEY_FIRST_NAME = "key_first_name"
private const val KEY_LAST_NAME = "key_last_name"
private const val DEFAULT_FIRST_NAME = "default_first_name"
private const val DEFAULT_LAST_NAME = "default_last_name"

// Сугубо сохранение данных, дабы разгрузить репозиторий имплементации, т.к. он может по итогу
// еще работать с сетью, нетворкингом и тд.

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,DEFAULT_FIRST_NAME)
            ?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME,DEFAULT_LAST_NAME)
            ?: DEFAULT_LAST_NAME

        return User(firstName = firstName, lastName = lastName)
    }
}