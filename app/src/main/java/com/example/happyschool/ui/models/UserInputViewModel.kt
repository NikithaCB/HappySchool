package com.example.happyschool.ui.models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.happyschool.data.LoginScreenState
import com.example.happyschool.data.UserDataUiEvents

class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(LoginScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG,"onEvent:UserNameEntered->> ")
                Log.d(TAG,"${uiState.value}")
            }

            is UserDataUiEvents.PasswordEntered -> {
                uiState.value = uiState.value.copy(
                    passwordEntered = event.password
                )
            }

            else -> {}
        }
    }

    fun isValidState() : Boolean {
        return !uiState.value.passwordEntered.isNullOrEmpty() && !uiState.value.nameEntered.isNullOrEmpty()
    }

}