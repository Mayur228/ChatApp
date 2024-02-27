package com.theappmakerbuddy.chitchathub.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
fun ChatItem(onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 1.dp, horizontal = 5.dp)
            .clickable {
                onItemClick()
            },
        backgroundColor = secondaryDark,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp,vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
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
                        .size(55.dp)
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
                        Text(
                            text = "Hello",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            fontSize = 17.sp
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Image(
                            modifier = Modifier.size(17.dp),
                            painter = painterResource(id = R.drawable.ic_readed),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.Gray)

                        )
                    }
                    Text(
                        text = "2 min ago",
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Red, shape = RoundedCornerShape(50.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "10",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}