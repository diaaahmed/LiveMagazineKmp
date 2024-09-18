package com.livemagazine.livemagazinekmp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.livemagazine.livemagazinekmp.depenencies.BaseResponseItem
import com.skydoves.landscapist.ImageOptions

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    finalItem:BaseResponseItem,
    buttonClick: (BaseResponseItem) -> Unit = {}
)
{
    Column(
        modifier = modifier
    ) {
        Text(finalItem.title)
        SpacerVertical15()
        com.skydoves.landscapist.coil3.CoilImage(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(size = 10.dp)),
            imageModel = {finalItem.image},
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )
        SpacerVertical15()
        Button(onClick = {
            buttonClick(finalItem)
        })
        {
            Text("CLick ")
        }
    }
}

@Composable
fun SpacerVertical15() {
    Spacer(modifier = Modifier.height(15.dp))

}