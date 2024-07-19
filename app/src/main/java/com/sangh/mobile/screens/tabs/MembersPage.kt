package com.sangh.mobile.screens.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sangh.mobile.components.CircleAvatarView
import com.sangh.mobile.components.Input
import com.sangh.mobile.components.ListTile

@Composable
fun MembersPage() {
    var searchQuery by remember { mutableStateOf("") }
    val members = listOf(
        "Rushabh",
        "Riya",
        "Anmol",
        "Areej",
        "SiD"
    )

    val filteredMembers = if (searchQuery.isEmpty()) {
        members
    } else {
        members.filter { it.contains(searchQuery, ignoreCase = true) }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            prefix = {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.padding(end = 10.dp)
                )
            },
            placeholder = "Search Members",
            suffix = {
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.then(Modifier.size(24.dp))) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null,
                        tint = Color(0xffffa500)
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn {
            items(filteredMembers.size) { idx ->
                ListTile(
                    modifier = Modifier.padding(vertical = 10.dp),
                    leading = {
                        CircleAvatarView(name = filteredMembers.elementAt(idx))
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    ,
                    title = filteredMembers.elementAt(idx),
                    titleFontSize = 18.sp,
                )
            }
        }
    }
}