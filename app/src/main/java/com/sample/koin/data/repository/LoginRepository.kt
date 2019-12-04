package com.sample.koin.data.repository

interface LoginRepository {
    fun login(username: String, password: String)
}