package com.theappmakerbuddy.chitchathub.calls.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.theappmakerbuddy.chitchathub.R
import com.theappmakerbuddy.chitchathub.ui.theme.secondaryDark

@Composable
fun CallItem() {
    Card(
        modifier = Modifier.padding(vertical = 1.dp, horizontal = 5.dp),
        backgroundColor = secondaryDark,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Left side: Profile image, username, and mobile number
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                        .size(60.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.padding(end = 12.dp))

                Column() {
                    Text(
                        text = "Person",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Row(
                        verticalAlignment =  Alignment.CenterVertically
                    ) {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.ic_incoming),
                            contentDescription = null,
                        )
                        Text(
                            text = "Today, 09:30 Am",
                            color = Color.Black,
                            fontWeight = FontWeight.ExtraLight,
                            fontSize = 16.sp
                        )
                    }

                }
            }

            Row() {
                IconButton(
                    onClick = {
                        // Handle icon button click
                    },
                    modifier = Modifier
                        .size(25.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_call),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))
                // Right side: IconButton
                IconButton(
                    onClick = {
                        // Handle icon button click
                    },
                    modifier = Modifier
                        .size(25.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_video_call),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                }
            }

        }
    }
}