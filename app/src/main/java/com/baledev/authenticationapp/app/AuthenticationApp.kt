package com.baledev.authenticationapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baledev.authenticationapp.ui.viewmodels.HomeViewModel
import com.baledev.authenticationapp.navigation.AppRouter
import com.baledev.authenticationapp.navigation.Screen
import com.baledev.authenticationapp.ui.screens.HomeScreen
import com.baledev.authenticationapp.ui.screens.LoginScreen
import com.baledev.authenticationapp.ui.screens.SignUpScreen
import com.baledev.authenticationapp.ui.screens.TermsAndConditionsScreen

@Composable
fun AuthenticationApp(homeViewModel: HomeViewModel = viewModel()) {
    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        if(homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
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