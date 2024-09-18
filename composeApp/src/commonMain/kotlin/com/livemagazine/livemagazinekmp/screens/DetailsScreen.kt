package com.livemagazine.livemagazinekmp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import cafe.adriel.voyager.core.screen.Screen
import com.livemagazine.livemagazinekmp.components.ProductItem
import com.livemagazine.livemagazinekmp.depenencies.BaseResponseItem

data class DetailsScreenVoyager(val item: BaseResponseItem):Screen{

    @Composable
    override fun Content() {
        DetailsScreenContent(item)
    }
}

@Composable
fun DetailsScreenContent(item: BaseResponseItem)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ProductItem(
            finalItem = item
        )
    }
}