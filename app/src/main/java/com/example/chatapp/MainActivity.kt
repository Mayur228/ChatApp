package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.common.BottomNavGraph
import com.example.chatapp.common.StandardScaffold
import com.example.chatapp.common.model.BottomNavItem
import com.example.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
//                    val navHostEngine = rememberNavHostEngine()

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
                        /*Box(modifier = Modifier.padding(innerPadding)) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }*/
                        BottomNavGraph(
                            navController = navController
                        )
                    }
                }
                /*Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Black)
                ) {
//                    OnBoarding()
//                    LoginPage()
                    HomeScreen()
                }*/
            }
        }
    }
}
