package com.baledev.authenticationapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baledev.authenticationapp.navigation.AppRouter
import com.baledev.authenticationapp.navigation.Screen
import com.baledev.authenticationapp.screens.LoginScreen

@Composable
fun AuthenticationApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = AppRouter.currentScreen, label = "") {
            currentState -> when (currentState.value) {
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.SignUpScreen -> {

                }

                is Screen.HomeScreen -> {

                }

                is Screen.TermsAndConditionsScreen -> {

                }
            }
        }
    }
}