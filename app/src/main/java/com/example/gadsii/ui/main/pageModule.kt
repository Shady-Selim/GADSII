package com.example.gadsii.ui.main

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pageModule = module {
    viewModel{ PageViewModel(get()) }
}