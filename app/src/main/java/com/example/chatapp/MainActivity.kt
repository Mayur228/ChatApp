package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.chat.ChatScreen
import com.example.chatapp.common.BottomNavGraph
import com.example.chatapp.common.StandardScaffold
import com.example.chatapp.common.model.BottomNavItem
import com.example.chatapp.login.LoginPage
import com.example.chatapp.onboarding.OnBoarding
import com.example.chatapp.registration.RegistrationScreen
import com.example.chatapp.ui.theme.ChatAppTheme
import com.example.chatapp.ui.theme.primaryDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = primaryDark
                ) {
                   /* val navController = rememberNavController()

                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    StandardScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            BottomNavItem.Message.destination,
                            BottomNavItem.Calls.destination,
                            BottomNavItem.Contacts.destination,
                            BottomNavItem.Settings.destination
                        )
                    ) { innerPadding ->
                        BottomNavGraph(
                            navController = navController
                        )
                    }*/

//                    ChatScreen()
//                    OnBoarding()
                    RegistrationScreen()
//                    LoginPage()
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    ChatAppTheme(darkTheme = true, dynamicColor = false) {
        ChatScreen()
    }
}
