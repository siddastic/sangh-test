package com.sangh.mobile.screens.tabs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sangh.mobile.components.ListTile
import com.sangh.mobile.components.PlaceholderBox
import com.sangh.mobile.components.PrimaryButton
import com.sangh.mobile.models.AppViewModel
import com.sangh.mobile.models.ViewMode
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(appViewModel: AppViewModel) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {

        ListTile(
            leading = {
                AsyncImage(
                    model = "https://api.dicebear.com/9.x/adventurer/png?seed=Gizmo",
                    contentDescription = "Translated description of what the image contains",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
            },
            title = "The Organization",
            titleFontSize = 18.sp,
            titleColor = Color(0xffffa500),
            subtitle = "SiD",
            subtitleFontSize = 26.sp,
            trailing = {
                IconButton(onClick = {
                    showBottomSheet = true
                }) {
                    Icon(Icons.Rounded.Settings, contentDescription = null)
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        PlaceholderBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            cornerRadius = 10.dp,
        )
        Spacer(modifier = Modifier.height(15.dp))
        MoreContentHeader(title = "Events")
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(6) { idx ->
                PlaceholderBox(
                    modifier = Modifier
                        .size(175.dp, 150.dp)
                        .padding(end = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        MoreContentHeader(title = "Timings", icon = Icons.Rounded.AccessTime)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Monday - Friday: 9:00 AM - 5:00 PM",
            color = Color.Gray.copy(alpha = .6f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            "Saturday: 9:00 AM - 1:00 PM",
            color = Color.Gray.copy(alpha = .6f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            "Sunday: 9:00 AM - 12:00 PM",
            color = Color.Gray.copy(alpha = .6f),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        ) {
            RelatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                icon = Icons.Rounded.Call,
                text = "Contact Us"
            )
            Spacer(modifier = Modifier.width(10.dp))
            RelatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                icon = Icons.Rounded.AttachMoney,
                text = "Donations"
            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                ViewModeBottomSheet(
                    onViewModeSelected = { newViewMode ->
                        appViewModel.setViewMode(newViewMode)
                    },
                    onClose = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun MoreContentHeader(
    title: String,
    icon: ImageVector = Icons.AutoMirrored.Rounded.ArrowForwardIos
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Icon(icon, contentDescription = null, tint = Color(0, 122, 255))
    }
}

@Composable
fun RelatedCard(modifier: Modifier = Modifier, icon: ImageVector, text: String) {
    Card(
        modifier = modifier
            .height(120.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(4.dp)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,

            ),
        border = BorderStroke(1.dp, Color.White),
        shape = RoundedCornerShape(10.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray.copy(alpha = .8f),
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray.copy(alpha = .6f)
            )
        }
    }
}

@Composable
fun ViewModeBottomSheet(
    onViewModeSelected: (ViewMode) -> Unit,
    onClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Select View Mode", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        PrimaryButton(
            onClick = {
                onViewModeSelected(ViewMode.Regular)
                onClose()
            }
        ) {
            Text("Regular")
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryButton(
            onClick = {
                onViewModeSelected(ViewMode.SiteAdmin)
                onClose()
            }
        ) {
            Text("Site Admin")
        }
        Spacer(modifier = Modifier.height(8.dp))
        PrimaryButton(
            onClick = {
                onViewModeSelected(ViewMode.Admin)
                onClose()
            }
        ) {
            Text("Admin")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomePagePreview() {
//    HomePage()
//}