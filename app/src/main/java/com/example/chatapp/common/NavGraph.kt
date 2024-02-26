package com.example.chatapp.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.calls.CallScreen
import com.example.chatapp.chat.ChatScreen
import com.example.chatapp.common.Constant.CHAT
import com.example.chatapp.common.Constant.FORGOT_PASSWORD
import com.example.chatapp.common.Constant.LOGIN
import com.example.chatapp.common.Constant.ONBOARDING
import com.example.chatapp.common.Constant.SINGUP
import com.example.chatapp.common.model.BottomNavItem
import com.example.chatapp.contact.ContactScreen
import com.example.chatapp.home.HomeScreen
import com.example.chatapp.login.ForgotPasswordPage
import com.example.chatapp.login.LoginPage
import com.example.chatapp.onboarding.OnBoarding
import com.example.chatapp.registration.RegistrationScreen
import com.example.chatapp.setting.SettingScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    val isFirstTime = PreferencesManager(LocalContext.current).getPreferenceValue(SharedPreferenceKey.IS_FIRST_TIME, true)
    val isLogin = PreferencesManager(LocalContext.current).getPreferenceValue(SharedPreferenceKey.IS_LOGIN, false)

    NavHost(
        navController = navController,
        startDestination = when {
            isFirstTime -> ONBOARDING
            isLogin -> BottomNavItem.Message.destination
            else -> LOGIN
        }
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
        composable(route = BottomNavItem.Message.destination) {
            HomeScreen(navController)
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
        composable(route = CHAT) {
           ChatScreen()
        }
        composable(route = FORGOT_PASSWORD) {
            ForgotPasswordPage(navController)
        }
    }
}