package com.livemagazine.livemagazinekmp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import com.livemagazine.livemagazinekmp.components.ProductItem
import com.livemagazine.livemagazinekmp.depenencies.BaseResponseItem
import com.livemagazine.livemagazinekmp.depenencies.HomeViewModelVoyager

import com.livemagazine.livemagazinekmp.depenencies.MyViewModel
import com.livemagazine.livemagazinekmp.depenencies.Resource
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

class HomeScreenVoyager: Screen{

    @OptIn(KoinExperimentalAPI::class)
    @Composable
    override fun Content() {

        val viewModel: MyViewModel = koinViewModel()

      //  val screenModel = rememberScreenModel { HomeViewModelVoyager() }

        val screenModel = getScreenModel<HomeViewModelVoyager>()


        val navigator = LocalNavigator.current

        LaunchedEffect(Unit)
        {
            screenModel.getProducts()
        }

        val productsResponse by screenModel.productTitle.collectAsState()

        HomeContent(productsResponse) { item ->
            navigator?.push(DetailsScreenVoyager(item))
        }
    }

}


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
        productsResponse,
        {}
    )
}


@Composable
fun HomeContent(
    productsResponse: Resource<List<BaseResponseItem>>,
    onButtonClick: (BaseResponseItem)-> Unit
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
                                    finalItem = item,
                                    buttonClick =  {item->
                                        onButtonClick(item)
                                    }
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}
