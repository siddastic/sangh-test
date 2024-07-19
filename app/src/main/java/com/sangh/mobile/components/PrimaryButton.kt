package com.sangh.mobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    onClick : () -> Unit,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    content: @Composable() (() -> Unit)? = null,
){
    Button(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(10, 132, 255),
            contentColor = contentColor
        )

    ) {
        content?.invoke()
    }
}