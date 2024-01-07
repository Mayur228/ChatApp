package com.example.chatapp.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.ui.theme.ChatAppTheme


@Composable
fun SocialMedia() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularImage(R.drawable.google_icon)
            Box(modifier = Modifier.size(10.dp))
            CircularImage(R.drawable.phone_icon)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray)
                    .height(1.dp)
            )
            Text(
                text = "OR",
                modifier = Modifier
                    .padding(10.dp),
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Gray)
                    .height(1.dp)
            )
        }
    }

}

@Composable
fun CircularImage(image: Int) {
    Card(
        modifier = Modifier
            .size(50.dp)
            .border(2.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            .background(
                color = Color.Black
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        ),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(25.dp)
            )
        }

    }


}