package com.example.gadsii.ui.form

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val formModule = module {
    viewModel{ FormViewModel(get()) }
}