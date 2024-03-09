package com.theappmakerbuddy.chitchathub.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.theappmakerbuddy.chitchathub.calls.CallScreen
import com.theappmakerbuddy.chitchathub.chat.ChatScreen
import com.theappmakerbuddy.chitchathub.common.Constant.CHAT
import com.theappmakerbuddy.chitchathub.common.Constant.FORGOT_PASSWORD
import com.theappmakerbuddy.chitchathub.common.Constant.LOGIN
import com.theappmakerbuddy.chitchathub.common.Constant.ONBOARDING
import com.theappmakerbuddy.chitchathub.common.Constant.SINGUP
import com.theappmakerbuddy.chitchathub.common.model.BottomNavItem
import com.theappmakerbuddy.chitchathub.contact.ContactScreen
import com.theappmakerbuddy.chitchathub.home.HomeScreen
import com.theappmakerbuddy.chitchathub.login.ForgotPasswordPage
import com.theappmakerbuddy.chitchathub.login.LoginPage
import com.theappmakerbuddy.chitchathub.onboarding.OnBoarding
import com.theappmakerbuddy.chitchathub.registration.RegistrationScreen
import com.theappmakerbuddy.chitchathub.setting.SettingScreen

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
            SettingScreen(navController)
        }
        composable(route = CHAT) {
           ChatScreen("")
        }
        composable(route = FORGOT_PASSWORD) {
            ForgotPasswordPage(navController)
        }
    }
}