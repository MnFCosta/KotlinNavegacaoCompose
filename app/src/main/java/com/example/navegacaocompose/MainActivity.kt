package com.example.navegacaocompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacaocompose.ui.theme.NavegacaoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacaoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold() {
        NavHost(navController = navController, startDestination = "login" ){
            composable("login"){
                LoginScreen(navController = navController)
            }
            composable("help"){
                HelpScreen(navController = navController)
            }
            composable("details"){
                DetailsScreen(navController = navController)
            }
            composable("welcome"){
                WelcomeScreen(navController = navController)
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Login Screen")
        Button(onClick = {
            navController.navigate("help")
        }) {
            Text(text = "Help")
        }
        Button(onClick = {
            navController.navigate("details")
        }) {
            Text(text = "Details")
        }
        Button(onClick = {
            navController.navigate("Welcome")
        }) {
            Text(text = "Login")
        }
    }
}

@Composable
fun HelpScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)) {
        Text(text = "Help Screen")
        Button(onClick = {
            navController.navigate("details"){
                popUpTo("login")
            }
        }) {
            Text(text="Details")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Green)) {
        Text(text = "Details Screen")
        Button(onClick = {
            navController.navigate("help"){
                popUpTo("login")
            }
        }) {
            Text(text="Help")
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {
        Text(text = "Welcome!")
        Button(onClick = {
            navController.navigate("login"){
                popUpTo("login"){
                    inclusive = true
                }
            }
        }) {
            Text(text="Logout")
        }
    }
}