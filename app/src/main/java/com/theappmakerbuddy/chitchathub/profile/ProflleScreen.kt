package com.theappmakerbuddy.chitchathub.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ProfilePage() {
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
        Column(modifier = Modifier.padding(innerPadding)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://images.healthshots.com/healthshots/en/uploads/2020/12/08182549/positive-person.jpg")
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                error = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = "Person",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            Text(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                text = "username",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            Text(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                text = "email",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
            Divider(color = Color.White,modifier = Modifier.padding(start= 15.dp,end = 15.dp))
            Text(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                text = "phone",
                color = Color.White,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
            )
        }
    }
}