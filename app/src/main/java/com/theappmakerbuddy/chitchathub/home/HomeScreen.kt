package com.theappmakerbuddy.chitchathub.home


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.AnimatedPreloader
import com.theappmakerbuddy.chitchathub.common.Constant.CHAT
import com.theappmakerbuddy.chitchathub.common.StandardToolbar
import com.theappmakerbuddy.chitchathub.home.component.ChatItem
import com.theappmakerbuddy.chitchathub.ui.theme.quicksand
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navHostController: NavHostController) {
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        // Simulate some background work or delay
        // You can replace this with your actual initialization or loading logic
        delay(2000)
        isLoading = false
    }

    AnimatedVisibility(visible = isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            AnimatedPreloader(animation = R.raw.chat_anim)
        }
    }

    if (!isLoading) {
        Home(navHostController)
    }
}

@Composable
fun Home(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            StandardToolbar(
                onBackArrowClicked = {
//                    onEvent(HomeUiEvents.NavigateBack)
                },
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Home",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = quicksand,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = false,
                navActions = {
                    IconButton(onClick = {
//                        onEvent(HomeUiEvents.OnSearchClick)
                    }) {
                        Image(
                            modifier = Modifier.size(27.dp),
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize().padding(innerPadding),
        ) {
          /*  AnimatedPreloader(modifier = Modifier
                .size(300.dp),
                animation = R.raw.empty_list)*/

            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding),
            ) {
                item {
                    ChatItem(onItemClick = {
                        navHostController.navigate(CHAT)
                    })
                }

                item {
                    ChatItem(onItemClick = {
                        navHostController.navigate(CHAT)
                    })
                }

                item {
                    ChatItem(onItemClick = {
                        navHostController.navigate(CHAT)
                    })
                }

                item {
                    ChatItem(onItemClick = {
                        navHostController.navigate(CHAT)
                    })
                }

                item {
                    ChatItem(onItemClick = {
                        navHostController.navigate(CHAT)
                    })
                }

            }
        }
    }
}