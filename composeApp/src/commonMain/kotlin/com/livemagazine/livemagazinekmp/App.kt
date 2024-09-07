@file:OptIn(KoinExperimentalAPI::class)

package com.livemagazine.livemagazinekmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.livemagazine.livemagazinekmp.depenencies.MyRepository
import com.livemagazine.livemagazinekmp.depenencies.MyViewModel
import com.livemagazine.networking.InsultCensorClient
import com.livemagazine.util.NetworkError
import com.livemagazine.util.onError
import com.livemagazine.util.onSuccess
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@Preview
fun App(
    client: InsultCensorClient
) {
    MaterialTheme {

        HomeScreen()


//        var censoredText by remember {
//            mutableStateOf<String?>(null)
//        }
//        var uncensoredText by remember {
//            mutableStateOf("")
//        }
//        var isLoading by remember {
//            mutableStateOf(false)
//        }
//        var errorMessage by remember {
//            mutableStateOf<NetworkError?>(null)
//        }
//        val scope = rememberCoroutineScope()
//
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
//        ) {
//            TextField(
//                value = uncensoredText,
//                onValueChange = { uncensoredText = it },
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .fillMaxWidth(),
//                placeholder = {
//                    Text("Uncensored text")
//                }
//            )
//            Button(onClick = {
//                scope.launch {
//                    isLoading = true
//                    errorMessage = null
//
//                    client.getLiveTest()
//                        .onSuccess {
//                            censoredText = it.currency_prices[0].currency
//                        }
//                        .onError {
//                            errorMessage = it
//                        }
//                    isLoading = false
//                }
//            }) {
//                if(isLoading) {
//                    CircularProgressIndicator(
//                        modifier = Modifier
//                            .size(15.dp),
//                        strokeWidth = 1.dp,
//                        color = Color.White
//                    )
//                } else {
//                    Text("Censor!")
//                }
//            }
//            censoredText?.let {
//                Text(it)
//            }
//            errorMessage?.let {
//                Text(
//                    text = it.name,
//                    color = Color.Red
//                )
//            }
//
//            LazyColumn {
//                items(10)
//                {
//                    Text("Hello $it ")
//                }
//            }
//        }
    }
}
