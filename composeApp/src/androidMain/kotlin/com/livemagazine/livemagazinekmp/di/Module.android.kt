package com.livemagazine.livemagazinekmp.di

import com.livemagazine.livemagazinekmp.depenencies.DbClient
import com.livemagazine.networking.createHttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platFormModule  = module {
    singleOf(::DbClient)
    single<HttpClientEngine> { OkHttp.create() }
    single { createHttpClient(get()) }
}