package com.baledev.authenticationapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baledev.authenticationapp.navigation.AppRouter
import com.baledev.authenticationapp.navigation.Screen
import com.baledev.authenticationapp.screens.HomeScreen
import com.baledev.authenticationapp.screens.LoginScreen
import com.baledev.authenticationapp.screens.SignUpScreen
import com.baledev.authenticationapp.screens.TermsAndConditionsScreen

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
                    SignUpScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
            }
        }
    }
}