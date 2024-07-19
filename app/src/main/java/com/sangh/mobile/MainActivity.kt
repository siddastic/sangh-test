package com.sangh.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sangh.mobile.models.AppViewModel
import com.sangh.mobile.screens.auth.LoginScreen
import com.sangh.mobile.screens.tabs.TabScreen
import com.sangh.mobile.ui.theme.SanghTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SanghTheme {
                SanghApplication()
            }
        }
    }
}

@Suppress("SpellCheckingInspection")
@Composable
fun SanghApplication(){
    val navController = rememberNavController();
    val appViewModel: AppViewModel = viewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("tabScreen") { TabScreen(appViewModel) }
    }
}