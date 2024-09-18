package com.livemagazine.livemagazinekmp.di

import com.livemagazine.livemagazinekmp.depenencies.HomeViewModelVoyager
import com.livemagazine.livemagazinekmp.depenencies.MyAgainRepositoryImpl
import com.livemagazine.livemagazinekmp.depenencies.MyRepository
import com.livemagazine.livemagazinekmp.depenencies.MyRepositoryImpl
import com.livemagazine.livemagazinekmp.depenencies.MyViewModel
import com.livemagazine.livemagazinekmp.depenencies.ServiceRepo
import com.livemagazine.livemagazinekmp.depenencies.ServiceRepoImpl
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platFormModule:Module

val sharedModule = module {

//    single<MyRepository> { MyRepositoryImpl(get()) }

    single<ServiceRepo> { ServiceRepoImpl(get()) }
    single{HomeViewModelVoyager(get())}

    singleOf(::MyRepositoryImpl).bind<MyRepository>()

//    singleOf(ServiceRepoImpl(get())).bind<ServiceRepo>()

 //    single { createHttpClient(get()) }

//    singleOf(::MyRepositoryImpl).bind<MyRepository>().withOptions { named("test") }

    singleOf(::MyAgainRepositoryImpl).bind<MyRepository>()

    viewModelOf(::MyViewModel)

//    viewModel {MyViewModel(get()) }

}