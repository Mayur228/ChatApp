package com.example.chatapp.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.calls.CallScreen
import com.example.chatapp.common.Constant.LOGIN
import com.example.chatapp.common.Constant.ONBOARDING
import com.example.chatapp.common.Constant.SINGUP
import com.example.chatapp.common.model.BottomNavItem
import com.example.chatapp.contact.ContactScreen
import com.example.chatapp.home.HomeScreen
import com.example.chatapp.login.LoginPage
import com.example.chatapp.onboarding.OnBoarding
import com.example.chatapp.registration.RegistrationScreen
import com.example.chatapp.setting.SettingScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ONBOARDING
    ) {
        composable(route = ONBOARDING) {
            OnBoarding(navController)
        }
        composable(route = LOGIN) {
            LoginPage(navController)
        }
        composable(route = SINGUP) {
            RegistrationScreen(navController)
        }
        /*composable(route = BottomNavItem.Settings.destination) {
           SettingScreen()
        }*/
    }
}