package com.example.kittylogin
//We Esihle mlinjana(222441712) and Owami Siganga(222231173) here by declare that we have done this project on our own.
//Any code obtained somewhere will be referenced in this project using some URL.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kittylogin.screens.DisplayScreen
import com.example.kittylogin.screens.ForgotPasswordScreen
import com.example.kittylogin.screens.LoginScreen
import com.example.kittylogin.screens.RegisterScreen
import com.example.kittylogin.screens.WelcomeScreen
import com.example.kittylogin.ui.theme.KittyLoginTheme
import com.example.kittylogin.viewModel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KittyLoginTheme {
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }

    @Composable
    fun AppNavigation(navController: NavHostController) {
        val userViewModel: UserViewModel = viewModel()

        NavHost(navController = navController, startDestination = "login") {

            composable("login") {
                LoginScreen(navController, userViewModel)
            }

            composable("register") {
                RegisterScreen(navController, userViewModel)
            }

            composable("display") {
                DisplayScreen(navController, userViewModel)
            }

            composable(
                route = "forgotPassword/{email}",
                arguments = listOf(navArgument("email") { type = NavType.StringType })
            ) { backStackEntry ->
                val email = backStackEntry.arguments?.getString("email") ?: ""
                ForgotPasswordScreen(navController, userViewModel, email)
            }

            composable(
                route = "welcome/{name}/{email}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("email") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: "User"
                val email = backStackEntry.arguments?.getString("email") ?: "Unknown"
                WelcomeScreen(name = name, email = email)
            }

            composable(
                "forgotPassword/{email}",
                arguments = listOf(navArgument("email") { type = NavType.StringType })
            ) { backStackEntry ->
                val email = backStackEntry.arguments?.getString("email") ?: ""
                ForgotPasswordScreen(navController, userViewModel, email)
            }

        }
    }
}
