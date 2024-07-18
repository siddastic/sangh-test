package com.sangh.mobile.screens.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TabScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val items = listOf("Home", "Events", "Discover", "Calendar", "Donations")

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            when (item) {
                                "Home" -> Icon(Icons.Filled.Home, contentDescription = null)
                                "Events" -> Icon(Icons.Default.Event, contentDescription = null)
                                "Discover" -> Icon(Icons.Filled.Search, contentDescription = null)
                                "Calendar" -> Icon(Icons.Default.CalendarMonth, contentDescription = null)
                                "Donations" -> Icon(Icons.Filled.Money, contentDescription = null)
                            }
                        },
                        label = { Text(item) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize(), contentAlignment = Alignment.Center) {
            when (selectedIndex) {
                0 -> HomePage()
                1 -> EventsPage()
                2 -> DiscoverPage()
                3 -> CalendarPage()
                4 -> DonationsPage()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavScreenPreview() {
        TabScreen()
}