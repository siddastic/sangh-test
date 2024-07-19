package com.sangh.mobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Input Placeholder",
    prefix: @Composable (() -> Unit)? = {},
    suffix: @Composable (() -> Unit)? = {},
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder, color = Color.Gray, fontSize = 16.sp)
        },
        prefix = prefix,
        suffix = suffix,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color(44, 44, 46),
            unfocusedContainerColor = Color(44, 44, 46)
        ),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = keyboardOptions
    )
}