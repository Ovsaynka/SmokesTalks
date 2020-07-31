package com.example.smokestalks

import com.example.smokestalks.data.APIService
import com.example.smokestalks.data.NetworkService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory <APIService> { NetworkService.smokesAndTalksApi }
    single <CategoriesRepository> { CategoriesRepositoryImpl(get<APIService>()) }
    single <CategoriesInteractor> { CategoriesInteractor(get<CategoriesRepository>()) }
    viewModel <MenuViewModel>{ MenuViewModel(get<CategoriesInteractor>()) }
}