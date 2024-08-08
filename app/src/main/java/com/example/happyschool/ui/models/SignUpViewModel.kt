package com.example.happyschool.ui.models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.happyschool.data.SignUpScreenState
import com.example.happyschool.data.UserDataUiEvents

class SignUpViewModel : ViewModel() {

    companion object {
        const val TAG = "SignUpViewModel"
    }

    var uiState = mutableStateOf(SignUpScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.FirstNameEntered -> {
                uiState.value = uiState.value.copy(
                    firstName = event.firstname
                )
                Log.d(TAG, "onEvent:UserNameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.LastNameEntered -> {
                uiState.value = uiState.value.copy(
                    lastName = event.lastname
                )
            }

            is UserDataUiEvents.DesiredNameEntered -> {
                uiState.value = uiState.value.copy(
                    desiredName = event.desiredname
                )
            }

            is UserDataUiEvents.ParentNameEntered -> {
                uiState.value = uiState.value.copy(
                    parentname = event.parentname
                )
            }

            is UserDataUiEvents.StandardEntered -> {
                uiState.value = uiState.value.copy(
                    standard = event.standard
                )
            }

            is UserDataUiEvents.EmailNameEntered -> {
                uiState.value = uiState.value.copy(
                    email = event.email
                )
            }

            is UserDataUiEvents.PasswordEntered -> {
                uiState.value = uiState.value.copy(
                    password = event.password
                )
            }

            else -> {}
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.firstName.isNullOrEmpty()
                && !uiState.value.lastName.isNullOrEmpty()
                && !uiState.value.desiredName.isNullOrEmpty()
                && !uiState.value.parentname.isNullOrEmpty()
                && !uiState.value.email.isNullOrEmpty()
                && !uiState.value.password.isNullOrEmpty()
                && !uiState.value.standard.isNullOrEmpty()
    }
}