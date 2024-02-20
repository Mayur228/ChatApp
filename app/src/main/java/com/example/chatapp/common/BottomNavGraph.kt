package com.example.chatapp.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.calls.CallScreen
import com.example.chatapp.common.model.BottomNavItem
import com.example.chatapp.contact.ContactScreen
import com.example.chatapp.home.HomeScreen
import com.example.chatapp.setting.SettingScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Message.destination
    ) {
        composable(route = BottomNavItem.Message.destination) {
           HomeScreen()
        }
        composable(route = BottomNavItem.Calls.destination) {
            CallScreen()
        }
        composable(route = BottomNavItem.Contacts.destination) {
            ContactScreen()
        }
        composable(route = BottomNavItem.Settings.destination) {
           SettingScreen()
        }
    }
}