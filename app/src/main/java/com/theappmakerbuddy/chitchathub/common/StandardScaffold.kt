package com.theappmakerbuddy.chitchathub.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.theappmakerbuddy.chitchathub.common.model.BottomNavItem
import com.theappmakerbuddy.chitchathub.ui.theme.selected
import com.theappmakerbuddy.chitchathub.ui.theme.unSelected

@Composable
fun StandardScaffold(
    navController: NavController,
    showBottomBar: Boolean = true,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Message,
        BottomNavItem.Calls,
        BottomNavItem.Contacts,
        BottomNavItem.Settings
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit,
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigation(
                    backgroundColor = Color.White,
                    contentColor = Color.White,
                    elevation = 12.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painterResource(id = item.icon),
                                    contentDescription = item.title,
                                    modifier = Modifier.size(25.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    fontSize = 9.sp
                                )
                            },
                            selectedContentColor = selected,
                            unselectedContentColor = unSelected,
                            alwaysShowLabel = true,
                            selected = currentDestination?.route?.contains(item.destination) == true,
                            onClick = {
                                navController.navigate(item.destination) {
                                    navController.graph.startDestinationRoute?.let { screenRoute ->
                                        popUpTo(screenRoute) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}