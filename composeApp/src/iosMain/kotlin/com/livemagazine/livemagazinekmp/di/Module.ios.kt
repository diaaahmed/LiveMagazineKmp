package com.livemagazine.livemagazinekmp.di

import com.livemagazine.livemagazinekmp.depenencies.DbClient
import com.livemagazine.networking.createHttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


actual val platFormModule: Module = module {

    singleOf(::DbClient)

    single<HttpClientEngine> { Darwin.create() }
    single { createHttpClient(get()) }

}