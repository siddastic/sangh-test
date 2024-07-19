package com.sangh.mobile.screens.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sangh.mobile.components.Input
import com.sangh.mobile.components.PlaceholderBox
import com.sangh.mobile.models.AppViewModel
import com.sangh.mobile.models.ViewMode

@Composable
fun EventsPage(appViewModel : AppViewModel) {
    var searchQuery by remember { mutableStateOf("") }
    val viewMode by appViewModel.viewMode
    Scaffold(
        floatingActionButton = {
            if (viewMode != ViewMode.Regular) {
                FloatingActionButton(onClick = { /* Handle FAB click */ }) {
                    Icon(Icons.Filled.Add, contentDescription = "Add Event")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
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
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = Color(0xffffa500)
                    )
                }
            })
            Spacer(modifier = Modifier.height(15.dp))
            repeat(10){
                EventCard()
            }
        }
    }
}

@Composable
fun EventCard(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        PlaceholderBox(
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
                .padding(vertical = 10.dp),
            cornerRadius = 10.dp,
        )
        Column(modifier = Modifier.padding(start = 15.dp), verticalArrangement = Arrangement.Center) {
            Text("Event", fontSize = 26.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text("10 June", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text("Description", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}