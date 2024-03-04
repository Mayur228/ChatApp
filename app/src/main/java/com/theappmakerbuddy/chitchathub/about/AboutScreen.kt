package com.theappmakerbuddy.chitchathub.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.common.StandardToolbar
import com.theappmakerbuddy.chitchathub.ui.theme.quicksand

@Composable
fun AboutScreen(){
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
                            text = "Profile",
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
        Column(){
            Text(
                modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp),
                text = "Chitchat Hub: Connect, Chat, and Share Moments",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
                )
            Spacer(modifier= Modifier.size(15.dp))
            Text(modifier = Modifier.padding(innerPadding),
                text = "ChitChat Hub is a dynamic and user-friendly chat application designed to connect people seamlessly. With its intuitive interface, ChitChat Hub allows users to engage in real-time conversations, share multimedia content, and stay connected with friends and family. Whether it's individual or group chats, the app offers a vibrant platform for lively discussions. Embrace the joy of communication",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )

        }
    }
}