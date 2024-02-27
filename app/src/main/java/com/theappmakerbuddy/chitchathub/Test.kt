package com.theappmakerbuddy.chitchathub

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader

@Composable
fun BottomNavigationWithLottieExample() {
    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf(
        BottomNavItem(Icons.Default.Home, "Home", R.raw.chat_icon_anim),
        BottomNavItem(Icons.Default.Search, "Search", R.raw.chat_icon_anim),
        BottomNavItem(Icons.Default.Home, "Video", R.raw.chat_icon_anim),
        BottomNavItem(Icons.Default.Home, "Mail", R.raw.chat_icon_anim),
        BottomNavItem(Icons.Default.Home, "Profile", R.raw.chat_icon_anim),
    )

    val density = LocalDensity.current.density
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.background(Color.White),
                backgroundColor = Color.White
            ) {
                tabs.forEachIndexed { index, item ->
                    val isSelected = selectedTab == index

                    BottomNavigationItem(
                        icon = {
                            /*LottieAnimation(
                                modifier = Modifier
                                    .size((32 * density).dp)
                                    .padding(8.dp)
                                    .clickable {
                                        selectedTab = index
                                    }
                            )*/
                            AnimatedPreloader(
                                modifier = Modifier
                                    .size((32 * density).dp)
                                    .padding(8.dp)
                                    .clickable {
                                        selectedTab = index
                                    }
                                    .scale(if (isSelected) 1.2f else 1f)
                                    .alpha(if (isSelected) 0.8f else 1f),
                                animation = item.lottieRes
                            )
                        },
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray,
                        alwaysShowLabel = false
                    )
                }
            }
        }
    ) { paddingValue ->
        // Content for each tab goes here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Content for ${tabs[selectedTab].label} tab")
        }
    }
}

data class BottomNavItem(
    val icon: ImageVector,
    val label: String,
    val lottieRes: Int
)

@Preview(showBackground = true)
@Composable
fun BottomNavigationWithLottiePreview() {
    BottomNavigationWithLottieExample()
}
