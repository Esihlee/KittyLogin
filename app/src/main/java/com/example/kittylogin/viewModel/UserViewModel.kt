package com.example.kittylogin.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kittylogin.data.UserDao
import com.example.kittylogin.data.UserDatabase
import com.example.kittylogin.model.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = UserDatabase.getDatabase(application).userDao()

    var userList = mutableStateListOf<User>()

    fun registerUser(user: User, onSuccess: () -> Unit) = viewModelScope.launch {
        userDao.insertUser(user)
        onSuccess()
    }

    fun login(
        email: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: () -> Unit
    ) = viewModelScope.launch {
        val user = userDao.getUser(email, password)
        if (user != null) onSuccess(user) else onError()
    }

    fun fetchAllUsers() = viewModelScope.launch {
        userList.clear()
        userList.addAll(userDao.getAllUsers())
    }

    fun updatePasswordByEmail(email: String, newPassword: String, onComplete: () -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUserByEmail(email)
            if (user != null) {
                val updatedUser = user.copy(password = newPassword)
                userDao.updateUser(updatedUser)
            }
            onComplete()
        }
    }





}
