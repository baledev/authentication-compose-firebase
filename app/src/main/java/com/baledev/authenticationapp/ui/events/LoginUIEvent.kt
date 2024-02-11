package com.baledev.authenticationapp.ui.events

sealed class LoginUIEvent {
    data class EmailChanged(val email:String): LoginUIEvent()
    data class PasswordChanged(val password: String): LoginUIEvent()

    data object LoginButtonClicked: LoginUIEvent()
}