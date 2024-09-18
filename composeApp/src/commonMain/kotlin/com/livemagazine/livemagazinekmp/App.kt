package com.livemagazine.livemagazinekmp

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.livemagazine.livemagazinekmp.screens.HomeScreenVoyager
import com.livemagazine.livemagazinekmp.tabs.CategoriesTab
import com.livemagazine.livemagazinekmp.tabs.HomeTab
import com.livemagazine.livemagazinekmp.tabs.MagazineTab
import com.livemagazine.networking.InsultCensorClient
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    client: InsultCensorClient
) {
    MaterialTheme {

        TabNavigator(HomeTab)
        {
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(CategoriesTab)
                        TabNavigationItem(MagazineTab)
                    }
                }
            ) {
                CurrentTab()
            }
        }



      //  HomeScreen()

    }
}

@Composable
private fun RowScope.TabNavigationItem(tab:Tab)
{
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab},
        label = { Text(tab.options.title) },
        icon = {
            tab.options.icon?.let {
                Icon(
                    painter = it,
                    contentDescription = "")
            }
        }
    )
}
