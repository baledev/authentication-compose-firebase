package com.baledev.authenticationapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baledev.authenticationapp.R
import com.baledev.authenticationapp.ui.components.AppToolbar
import com.baledev.authenticationapp.ui.components.NavigationDrawerBody
import com.baledev.authenticationapp.ui.components.NavigationDrawerHeader
import com.baledev.authenticationapp.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    homeViewModel.getUserData()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader(value = homeViewModel.emailId.value)
                NavigationDrawerBody(
                    navigationDrawerItems = homeViewModel.navigationItemsList,
                    onNavigationItemClicked = {
                        Log.d("ComingHere", "Inside_onNavigationItemClicked")
                        Log.d("ComingHere", "Message: ${it.itemId} ${it.title}")
                    }
                )
            }
        },
    ) {
        Scaffold(
            topBar = {
                AppToolbar(
                    toolbarTitle = stringResource(id = R.string.home),
                    logoutButtonClicked = { homeViewModel.logout() },
                    navigationIconClicked = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(contentPadding)
            ) {

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}