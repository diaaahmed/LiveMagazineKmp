package com.livemagazine.livemagazinekmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.livemagazine.livemagazinekmp.components.ProductItem
import com.livemagazine.livemagazinekmp.depenencies.BaseResponseItem

import com.livemagazine.livemagazinekmp.depenencies.MyViewModel
import com.livemagazine.livemagazinekmp.depenencies.Resource
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen()
{
    val viewModel: MyViewModel = koinViewModel()

    LaunchedEffect(Unit)
    {
        viewModel.getProducts()
    }

    val productsResponse by viewModel.productTitle.collectAsState()

    HomeContent(
        productsResponse
    )
}


@Composable
fun HomeContent(
    productsResponse: Resource<List<BaseResponseItem>>,
)
{
    KoinContext {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        )
        {
            Column {

                when(productsResponse)
                {
                    is Resource.Empty -> {
                        Text("Empty data")
                    }
                    is Resource.Error -> {
                        Text("Error ${productsResponse.message}")
                    }
                    is Resource.Loading -> {
                        Text("Loading")
                    }
                    is Resource.Success -> {

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            items(productsResponse.data!!)
                            {item->
                                ProductItem(
                                    finalItem = item
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
