package com.theappmakerbuddy.chitchathub.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.StandardToolbar
import com.theappmakerbuddy.chitchathub.notification.component.NotificationItem
import com.theappmakerbuddy.chitchathub.ui.theme.quicksand

@Composable
fun NotificationScreen(){
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
                            text = "Setting",
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
                            painter = painterResource(id = R.drawable.ic_logout),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
        ) {

            item {
                NotificationItem("Notification")
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                NotificationItem("Notification")
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }
            item {
                NotificationItem("Notification")
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                NotificationItem("Notification")
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }

            item {
                NotificationItem("Notification")
                Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            }
        }
    }
}