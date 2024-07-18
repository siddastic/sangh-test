package com.sangh.mobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PlaceholderBox(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(44,44,46),
    contentAlignment: Alignment = Alignment.Center,
    cornerRadius: Dp = 8.dp,
    icon: ImageVector = Icons.Rounded.Add,
    iconContentDescription: String? = null
) {
    Box(
        contentAlignment = contentAlignment,
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(cornerRadius)),
    ) {
        Icon(icon, contentDescription = iconContentDescription, tint = Color.Gray)
    }
}
