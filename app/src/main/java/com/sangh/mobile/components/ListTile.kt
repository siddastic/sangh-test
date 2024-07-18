package com.sangh.mobile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListTile(
    modifier: Modifier = Modifier,
    title: String? = null,
    subtitle: String? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    titleFontSize: TextUnit = 26.sp,
    subtitleFontSize: TextUnit = 18.sp,
    titleColor: Color = Color.Unspecified,
    subtitleColor: Color = Color.Unspecified
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        leading?.invoke()
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            title?.let {
                Text(text = it, fontSize = titleFontSize, color = titleColor)
            }
            subtitle?.let {
                Text(text = it, fontSize = subtitleFontSize, color = subtitleColor)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        trailing?.invoke()
    }
}