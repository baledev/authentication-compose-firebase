package com.baledev.authenticationapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baledev.authenticationapp.R
import com.baledev.authenticationapp.components.NavigationDrawerHeader
import com.baledev.authenticationapp.data.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    homeViewModel.getUserData()

//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        topBar = {
//            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
//                logoutButtonClicked = {
//                    homeViewModel.logout()
//                },
//                navigationIconClicked = {
//                    coroutineScope.launch {
//                        scaffoldState.drawerState.open()
//                    }
//                }
//            )
//        },
//        gesturesEnabled = drawerState.isOpen,
//        content = {
//            NavigationDrawerHeader(homeViewModel.emailId.value)
//            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
//                onNavigationItemClicked = {
//                    Log.d("ComingHere","inside_NavigationItemClicked")
//                    Log.d("ComingHere","${it.itemId} ${it.title}")
//                })
//        }
//
//    ) { paddingValues ->
//
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(paddingValues)
//        ) {
//            Column(modifier = Modifier.fillMaxSize()) {
//
//
//            }
//
//        }
//    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}