package com.sample.koin.di

import com.sample.koin.data.repository.LoginRepository
import com.sample.koin.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

// region Application Module

val applicationModule = module {

    // Login Repository
    single<LoginRepository> { LoginRepositoryImpl() }

}

// endregion Application Module