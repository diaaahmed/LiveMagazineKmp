package com.livemagazine.livemagazinekmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.livemagazine.livemagazinekmp.di.initKoin
import com.livemagazine.networking.InsultCensorClient
import com.livemagazine.networking.createHttpClient
import io.ktor.client.engine.darwin.Darwin


fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App(
        client = remember {
            InsultCensorClient(createHttpClient(Darwin.create()))
        }
    )
}