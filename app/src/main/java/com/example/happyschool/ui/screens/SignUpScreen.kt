package com.example.happyschool.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happyschool.R
import com.example.happyschool.data.UserDataUiEvents
import com.example.happyschool.ui.models.SignUpViewModel

@Composable
fun SignUpScreen() {
    val scrollState = rememberScrollState()
    val signUpViewModel = SignUpViewModel()
    var showDialog by remember { mutableStateOf(false) }
    var alertTitle: String = ""
    var alertText: String = ""
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .verticalScroll(state = scrollState)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            androidx.compose.material3.Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.teal_200)),
                text = "Sign Up",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(textValue = "First Name", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.FirstNameEntered(it)
                )
            } , 15)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Last Name", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.LastNameEntered(it)
                )
            }, 15)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Email", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.EmailNameEntered(it)
                )
            }, 40)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Desired Name", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.DesiredNameEntered(it)
                )
            } ,30)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Class", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.StandardEntered(it)
                )
            },10)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Parent Name", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.ParentNameEntered(it)
                )
            },30)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "Password", textSize = 18.sp)
            TextField(onTextChanged = {
                signUpViewModel.onEvent(
                    UserDataUiEvents.PasswordEntered(it)
                )
            },15)
            Spacer(modifier = Modifier.size(20.dp))

            ButtonComponent("Sign Up",
                goToDetailsScreen = {
                    if (signUpViewModel.isValidState()) {
                        showDialog = true
                        alertTitle = "Success"
                        alertText = "Data Saved Successfully"
                    } else {
                        showDialog = true
                        alertTitle = "Error"
                        alertText = "Data Not Saved"
                    }
                }
            )
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false // Hide dialog when dismissed
                    },
                    title = { Text(alertTitle) },
                    text = { Text(alertText) },
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
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}