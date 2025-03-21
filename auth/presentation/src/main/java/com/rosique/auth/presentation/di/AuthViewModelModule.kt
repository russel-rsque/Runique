package com.rosique.auth.presentation.di

import com.rosique.auth.presentation.login.LoginViewModel
import com.rosique.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}