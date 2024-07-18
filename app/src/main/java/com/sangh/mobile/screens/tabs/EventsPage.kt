package com.sangh.mobile.screens.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sangh.mobile.components.Input

@Composable
fun EventsPage() {
    var searchQuery by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(value = searchQuery, onValueChange = {
            searchQuery = it
        }, prefix = {
            Icon(
                Icons.Outlined.Search,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.padding(end = 10.dp)
            )
        }, placeholder = "Search Events", suffix = {
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.then(Modifier.size(24.dp))) {
                Icon(Icons.Default.MoreVert, contentDescription = null, tint = Color(0xffffa500))
            }
        })
    }
}