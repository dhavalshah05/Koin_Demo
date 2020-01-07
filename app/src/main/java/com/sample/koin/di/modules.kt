package com.sample.koin.di

import com.sample.koin.MainViewModel
import com.sample.koin.data.repository.LoginRepository
import com.sample.koin.data.repository.LoginRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

// region Application Module

val applicationModule = module {

    // Login Repository
    single<LoginRepository> { LoginRepositoryImpl() }

    // Named Dependencies
    single(qualifier = named("API_KEY")) { "1234567890" }
    factory(qualifier = named("STATIC_TOKEN")) { "AZAZIFIFGHT" }

    // ViewModel Dependencies
    viewModel { MainViewModel(get()) }

}

// endregion Application Module