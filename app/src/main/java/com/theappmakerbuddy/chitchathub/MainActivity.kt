package com.theappmakerbuddy.chitchathub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.theappmakerbuddy.chitchathub.common.NavGraph
import com.theappmakerbuddy.chitchathub.common.StandardScaffold
import com.theappmakerbuddy.chitchathub.common.model.BottomNavItem
import com.theappmakerbuddy.chitchathub.ui.theme.ChatAppTheme
import com.theappmakerbuddy.chitchathub.ui.theme.primaryDark
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = primaryDark
                ) {
                    val navController = rememberNavController()

                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    StandardScaffold(
                        navController = navController,
                        showBottomBar =
                        route in listOf(
                            BottomNavItem.Message.destination,
                            BottomNavItem.Calls.destination,
                            BottomNavItem.Contacts.destination,
                            BottomNavItem.Settings.destination
                        )
                    ) { innerPadding ->
                        NavGraph(navController = navController)
                    }

                }
            }
        }
    }
}
