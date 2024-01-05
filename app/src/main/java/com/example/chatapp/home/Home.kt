package com.example.chatapp.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.home.component.BottomNavigationScreens
import com.example.chatapp.home.component.StatusList
import com.example.chatapp.ui.theme.Bg

@Composable
fun Home() {
    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf(
        BottomNavigationScreens.Message,
        BottomNavigationScreens.Calls,
        BottomNavigationScreens.Contacts,
        BottomNavigationScreens.Setting
    )

    val shadowColor = Color.Red
    val cardBackgroundColor = Color.Black


    val shadowedBackgroundColor = Color(
        red = (shadowColor.red * 0.2 + cardBackgroundColor.red * 0.8).toFloat(),
        green = (shadowColor.green * 0.2 + cardBackgroundColor.green * 0.8).toFloat(),
        blue = (shadowColor.blue * 0.2 + cardBackgroundColor.blue * 0.8).toFloat(),
        alpha = cardBackgroundColor.alpha
    )

    Scaffold(
        bottomBar = {
            Card(
                modifier = Modifier
                    .background(color = shadowedBackgroundColor)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    tabs.forEach { screen ->
                        AddItem(
                            screen = screen,
                        )
                    }
                }
            }

        },
    ) { innerPadding ->
        // Content of each screen goes here
        tabs[selectedTab].screenContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavigationScreens,
//    currentDestination: NavDestination?,
//    navController: NavHostController
) {
//    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

//    val background =
//        if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent
//
//    val contentColor =
//        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clickable(onClick = {

            })
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = screen.icon),
                contentDescription = "icon",
                modifier = Modifier
                    .height(40.dp)
            )
        }
    }
}

@Composable
fun MessageContent(modifier: Modifier){
    Column(
        modifier = Modifier
            .background(color = Bg)
            .padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(25.dp)
            )
            Spacer(Modifier.weight(1f))
            Text("Home", color = Color.White)
            Spacer(Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .size(40.dp)
                    .border(2.dp, MaterialTheme.colorScheme.secondary, CircleShape),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.google_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }

            }
        }
        Spacer(Modifier.size(15.dp))
        StatusList()
    }
}