package com.example.happyschool.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.happyschool.data.UserDataUiEvents
import com.example.happyschool.ui.models.UserInputViewModel


@Composable
fun LoginScreen(
    userInputViewModel: UserInputViewModel,
    navController: NavHostController?,
    showDashboardScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        TopBar("Hello,\nWelcome to Happy \nSchool Application", 125.dp)

        Spacer(modifier = Modifier.size(25.dp))

        //Username Field
        TitlesEntered("Username", 30, onTextChanged = {
            userInputViewModel.onEvent(
                UserDataUiEvents.UserNameEntered(it)
            )
        })

        Spacer(modifier = Modifier.size(25.dp))

        //Password Field
        TitlesEntered("Password", 15, onTextChanged = {
            userInputViewModel.onEvent(
                UserDataUiEvents.PasswordEntered(it)
            )
        })

        // Login button
        ButtonComponent("Login",
            goToDetailsScreen = {
                if (userInputViewModel.isValidState()) {
                    showDashboardScreen(
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.passwordEntered
                        )
                    )
                } else {
                    showDialog = true
                }
            }
        )

        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false // Hide dialog when dismissed
                },
                title = { Text("Validation Error") },
                text = { Text("Please Enter Valid Credentials") },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false // Hide dialog when button is clicked
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
                .align(AbsoluteAlignment.Left)
        )

        Row {
            Text(
                text = "If New user ? ",
                fontSize = 18.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
            )

            Text(
                text = "Sign Up",
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .clickable {
                        navController?.navigate(Routes.SIGN_UP_SCREEN)
                    }
            )
        }

    }
}




