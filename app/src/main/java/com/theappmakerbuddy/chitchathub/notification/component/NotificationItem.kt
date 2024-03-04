package com.theappmakerbuddy.chitchathub.notification.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theappmakerbuddy.chitchathub.R

@Composable
fun NotificationItem(notification: String){
    Row(){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_placeholder),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape)
            )
        }

        Text(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp),
            text = notification,
            color = Color.White,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
        )
    }
}