package com.example.happyschool.data

sealed class UserDataUiEvents {
    //Login Data
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class PasswordEntered(val password: String) : UserDataUiEvents()
    //Sign Up Data
    data class FirstNameEntered(val firstname: String) : UserDataUiEvents()
    data class LastNameEntered(val lastname: String) : UserDataUiEvents()
    data class DesiredNameEntered(val desiredname: String) : UserDataUiEvents()
    data class EmailNameEntered(val email: String) : UserDataUiEvents()
    data class StandardEntered(val standard: String) : UserDataUiEvents()
    data class ParentNameEntered(val parentname: String) : UserDataUiEvents()
}