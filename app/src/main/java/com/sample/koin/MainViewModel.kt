package com.sample.koin

import androidx.lifecycle.ViewModel
import com.sample.koin.data.repository.LoginRepository

class MainViewModel constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    fun login(username: String, password: String) {
        loginRepository.login(username, password)
    }
}