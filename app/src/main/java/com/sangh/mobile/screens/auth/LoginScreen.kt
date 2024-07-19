package com.sangh.mobile.screens.auth

//noinspection UsingMaterialAndMaterial3Libraries
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sangh.mobile.R
import com.sangh.mobile.components.Input
import com.sangh.mobile.components.PrimaryButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    var phoneNumber by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Get Started | Sangh") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Welcome to Sangh",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                Box(modifier = Modifier.height(20.dp))

                Input(value = phoneNumber, onValueChange = {
                    phoneNumber = it
                }, prefix = {
                    Text("+91 ", color = Color.Gray)
                }, placeholder = "Phone Number", keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

                Box(modifier = Modifier.height(20.dp))

                PrimaryButton(
                    onClick = {
                        navController?.navigate("tabScreen"){
                            popUpTo("login") { inclusive = true }
                            launchSingleTop = true
                        }
                    },
                ) {
                    Text(
                        text = "Get OTP",
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                )

                TextButton(
                    onClick = {
                        navController?.navigate("tabScreen"){
                            popUpTo("login") { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                ) {
                    Text("Skip for now")
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
