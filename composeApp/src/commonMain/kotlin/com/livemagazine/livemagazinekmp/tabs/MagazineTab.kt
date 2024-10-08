package com.livemagazine.livemagazinekmp.tabs

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object MagazineTab: Tab {
    @Composable
    override fun Content() {
        Text("Magazine tab")
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Call)

            return remember {
                TabOptions(
                    index = 2u,
                    title = "Magazine",
                    icon = icon
                )
            }
        }
}