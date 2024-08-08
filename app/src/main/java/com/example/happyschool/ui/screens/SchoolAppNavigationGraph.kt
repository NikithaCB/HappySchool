package com.example.happyschool.ui.screens

import androidx.compose.runtime.Composable
import com.example.happyschool.ui.models.UserInputViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun SchoolAppNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(userInputViewModel,navController, showDashboardScreen = {
                println(it.first)
                println(it.second)
                navController.navigate(Routes.DASHBOARD_SCREEN + "/${it.first}/${it.second}")
            })

        }
        composable("${Routes.DASHBOARD_SCREEN}/{${Routes.USER_NAME}}/{${Routes.PASSWORD}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME) { type = NavType.StringType },
                navArgument(name = Routes.PASSWORD) { type = NavType.StringType }
            )
        ) {
            val userName = it?.arguments?.getString(Routes.USER_NAME)
            val password = it?.arguments?.getString(Routes.PASSWORD)
            if (userName != null) {
                if (password != null) {
                    Dashboard(userName, password)
                }
            }
        }

        composable(Routes.SIGN_UP_SCREEN) {
            SignUpScreen()
        }
    }
}